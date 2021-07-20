/**
 * 
 */
package com.fast.caixaMultibanco.recursos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fast.caixaMultibanco.entidades.Acesso;
import com.fast.caixaMultibanco.entidades.Cliente;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxAcesso;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxLogin;
import com.fast.caixaMultibanco.services.AcessoServico;
import com.fast.caixaMultibanco.services.ClienteServico;
import com.fast.caixaMultibanco.services.excecoes.AcessoExcecao;
import com.fast.caixaMultibanco.services.excecoes.SaqueExcecao;

import tools.Criptografar;

/**
 * 
 * @author Maurilio
 * @author allan
 * @version 0.0.5
 */

@RestController
@RequestMapping(value = "/banco")
public class UserController {

	@Autowired
	private AcessoServico acessoServico;

//	@Autowired
//	private BancoServico bancoServico;
//	
	@Autowired
	private ClienteServico clienteServico;

//	@Autowired
//	private CaixaServico caixaServico;
//	

	@PostMapping("/loginBanco")
	@ResponseBody
	AuxAcesso loginBanco(@RequestBody AuxLogin login) throws Exception {

		Acesso novoAcesso = new Acesso(null, null, null, null, null);
		Cliente cliente = clienteServico.findById(login.getLogin());

		if (cliente.getSenha().equals(Criptografar.gerarHashMD5(login.getSenha()))) {
			if (cliente.getConta().equals(login.getConta())) {
				novoAcesso.setCaixa(login.getCaixa());
				novoAcesso.setCliente(cliente);
				Instant now = Instant.now();
				novoAcesso.setTempoInicial(now.toEpochMilli());
				novoAcesso.setTempoFinal();
				novoAcesso.setToken(Criptografar.gerartoken(novoAcesso.getCliente().getLogin()));
				cliente.setAcesso(novoAcesso);
				cliente.setDt_acesso(now);
				acessoServico.insert(novoAcesso);
				clienteServico.insert(cliente);
				AuxAcesso auxAcesso = new AuxAcesso();
				auxAcesso.setAcesso(novoAcesso.getToken());
				return auxAcesso;
			}
		}
		return null;
	}


	@GetMapping("/consultarSaldo")
	ResponseEntity<Object> consultarSaldo(@RequestBody AuxAcesso acesso) {
		List<Object> achou;
		
		 achou = validarAcesso(acesso);
		 
		 Cliente achouCliente = (Cliente) achou.get(0);
		 Acesso achouAcesso = (Acesso) achou.get(1);
		
		if(achouCliente != null) {
			Instant now = Instant.now();
			if(now.toEpochMilli() > achouAcesso.getTempoFinal()){
				System.out.println("tempo agora " +now.toEpochMilli() + "tempo que achei " + achouAcesso.getTempoFinal() + " Acabou o tempo");
				acessoServico.delete(achouAcesso.getId());
				return null;
			}else {
				Locale.setDefault( Locale.US);
				return ResponseEntity.ok().body(String.format("{ \"saldo\": \"%.2f\"}", achouCliente.getSaldo()));
			}
		}
		return ResponseEntity.badRequest().body(null);
		
	}
	
	private List<Object> validarAcesso(AuxAcesso acesso) {
		List<Acesso> lista = acessoServico.findAll();
		String acc = acesso.getAcesso();
		Acesso achouAcesso = null;
		
		for (Acesso obj : lista) {
			String token = obj.getToken();		
			if (acc.equals(token)){
				achouAcesso = obj;
			}else {
				throw new AcessoExcecao();
				}
		}
		List<Cliente> clientes = clienteServico.findAll();
		Cliente achouCliente = null;
		
		for (Cliente cliente : clientes) {
			if(cliente.getAcesso() != null) {
				String tokenCliente = cliente.getAcesso().getToken();
				if(acc.equals(tokenCliente)) {
					achouCliente = cliente;
				}
				else {
					throw new AcessoExcecao();
				}
			}
		}
		
		List<Object> encontrou = new ArrayList<>();
		encontrou.add(0, achouCliente);
		encontrou.add(1, achouAcesso);
		return encontrou;
		
	}
	
	
	@GetMapping("/fazerSaque")
	ResponseEntity<Object> fazerSaque(){
		
		throw new SaqueExcecao("Valor Indisponivel");
	}

}
