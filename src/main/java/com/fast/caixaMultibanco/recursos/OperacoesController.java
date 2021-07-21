/**
 * 
 */
package com.fast.caixaMultibanco.recursos;

import java.time.Instant;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fast.caixaMultibanco.entidades.Acesso;
import com.fast.caixaMultibanco.entidades.Caixa;
import com.fast.caixaMultibanco.entidades.Cliente;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxAcesso;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxCliente;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxConsultaCliente;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxLogin;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxSaqueAcesso;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxSaqueRetorno;
import com.fast.caixaMultibanco.services.AcessoServico;
import com.fast.caixaMultibanco.services.CaixaServico;
import com.fast.caixaMultibanco.services.ClienteServico;
import com.fast.caixaMultibanco.services.excecoes.AcessoExcecao;
import com.fast.caixaMultibanco.services.excecoes.RecursoNaoEncontradoExcecao;
import com.fast.caixaMultibanco.services.excecoes.SaqueExcecao;
import com.fast.caixaMultibanco.services.excecoes.TempoExpiradoException;

import tools.Criptografar;

/**
 * 
 * @author Maurilio
 * @author allan
 * @version 0.1.0
 */

@RestController
@RequestMapping(value = "/banco")
public class OperacoesController {

	@Autowired
	private AcessoServico acessoServico;

//	@Autowired
//	private BancoServico bancoServico;
//	
	@Autowired
	private ClienteServico clienteServico;

	@Autowired
	private CaixaServico caixaServico;

	@PostMapping("/loginBanco")
	@ResponseBody
	AuxAcesso loginBanco(@RequestBody AuxLogin login) throws Exception {

		Acesso novoAcesso = new Acesso(null, null, null, null, null);
		Cliente cliente = clienteServico.findById(login.getLogin());
		Caixa caixa = caixaServico.findById(login.getCaixa());

		if (cliente.getSenha().equals(Criptografar.gerarHashMD5(login.getSenha()))
				&& cliente.getLogin() == login.getLogin() && cliente.getConta().equals(login.getConta())
				&& caixa != null) {
			novoAcesso.setCaixa(login.getCaixa());
			novoAcesso.setCliente(cliente);
			Instant now = Instant.now();
			novoAcesso.setTempoInicial(now.toEpochMilli());
			novoAcesso.setTempoFinal();
			novoAcesso.setToken(Criptografar.gerartoken(novoAcesso.getCliente().getLogin()));
			cliente.setAcesso(novoAcesso);
			cliente.setDt_acesso(now);
			acessoServico.insert(novoAcesso);
			AuxAcesso auxAcesso = new AuxAcesso();
			auxAcesso.setAcesso(novoAcesso.getToken());
			return auxAcesso;
		} else {
			throw new RecursoNaoEncontradoExcecao(
					cliente.getLogin()); /* PROBLEMA EXCEÇÃO ERRO 300 – conta, usuário ou senha// inválidos(s):S */
		}

	}

	@GetMapping("/consultarSaldo")
	ResponseEntity<Object> consultarSaldo(@RequestBody AuxAcesso acesso) {
		Cliente cliente = validarAcesso(acesso).getCliente();
		Locale.setDefault(Locale.US);
		return ResponseEntity.ok().body(String.format("{ \"saldo\": \"%.2f\"}", cliente.getSaldo()));

	}

	@PostMapping("/fazerSaque")
	ResponseEntity<AuxSaqueRetorno> fazerSaque(@RequestBody AuxSaqueAcesso auxSaqueAcesso) {
		Cliente cliente = validarAcesso(auxSaqueAcesso.getAcesso()).getCliente();
		Caixa caixa = caixaServico.findById(validarAcesso(auxSaqueAcesso.getAcesso()).getCaixa());
		if (caixa.verificarSaldoSuficiente(auxSaqueAcesso.getValor(), cliente)) {
			if (caixa.saque(auxSaqueAcesso.getValor()) && auxSaqueAcesso.getValor() >= 2) {
				int[] notas = caixa.calcularCedulas(auxSaqueAcesso.getValor());
				cliente.setSaldo(cliente.getSaldo() - auxSaqueAcesso.getValor());
				caixaServico.atualizarCaixa(caixa);
				System.out.println("SALDO DO CLIENTE ATUALIZADO: " + cliente.getSaldo());
				System.out.println("QUANTIDADE DE NOTAS ATUALIZADAS: " + caixa);

				AuxSaqueRetorno retorno = new AuxSaqueRetorno(cliente.getCodigo_banco(), cliente.getConta(), notas[3],
						notas[2], notas[1], notas[0]);
				return ResponseEntity.ok().body(retorno);

			} else {
//				System.out.println("VALOR INDISPONÍVEL, PROCURE OUTRO CAIXA");
				/*
				 * EXCEÇÃO ERRO 300 - "mensagem": " VALOR INDISPONÍVEL, PROCURE OUTRO CAIXA"
				 */
				throw new SaqueExcecao(" VALOR INDISPONÍVEL, PROCURE OUTRO CAIXA");

			}

		} else {
//			System.out.println("SALDO INSUFICIÊNTE");
			/* EXCEÇÃO ERRO 300 - "mensagem": "SALDO INSUFICIÊNTE" */
			throw new SaqueExcecao("SALDO INSUFICIÊNTE");

		}
	}

	@GetMapping("/consultarDadosConta")
	ResponseEntity<Object> consultarDadosConta(@RequestBody AuxAcesso acesso) {
		Cliente cliente = validarAcesso(acesso).getCliente();
		if (cliente != null) {
			AuxConsultaCliente retorno = new AuxConsultaCliente(cliente.getCodigo_banco(), cliente.getNome_banco(),
					cliente.getConta(), cliente.getNome_cliente(), cliente.getTelefone_cliente());
			return ResponseEntity.ok().body(retorno);
		} else {
			throw new AcessoExcecao();
		}
	}

	@PutMapping("/alterarDadosConta")
	void alterarCliente(@RequestBody AuxCliente dados) {
		AuxAcesso acesso = new AuxAcesso(dados.getAcesso());
		Cliente cliente = (validarAcesso(acesso).getCliente());
		cliente.setNome_cliente(dados.getNome_cliente());
		cliente.setTelefone_cliente(dados.getTelefone_cliente());

		clienteServico.update(cliente.getLogin(), cliente);
	}

	/* Valida o Acesso pelo token e pelo tempo */
	private Acesso validarAcesso(AuxAcesso acesso) {
		List<Acesso> listaAcesso = acessoServico.findAll();
		String acc = acesso.getAcesso();
		Acesso achouAcesso = null;

		for (Acesso obj : listaAcesso) {
			String token = obj.getToken();
			if (acc.equals(token)) {
				achouAcesso = obj;
			}
		}
		if (achouAcesso == null) {
			throw new AcessoExcecao();
		}

		Instant now = Instant.now();
		if (now.toEpochMilli() > achouAcesso.getTempoFinal()) {
//			acessoServico.delete(achouAcesso.getId());
			throw new TempoExpiradoException();
		}

		List<Cliente> clientes = clienteServico.findAll();
		Cliente achouCliente = null;

		for (Cliente cliente : clientes) {
			if (cliente.getAcesso() != null) {
				String tokenCliente = cliente.getAcesso().getToken();
				if (acc.equals(tokenCliente)) {
					achouCliente = cliente;
				}
			}
		}

		if (achouCliente == null) {
			throw new AcessoExcecao();
		}

		return achouAcesso;

	}

}
