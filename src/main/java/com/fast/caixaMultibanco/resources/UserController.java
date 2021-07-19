/**
 * 
 */
package com.fast.caixaMultibanco.resources;

import java.time.Instant;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fast.caixaMultibanco.Entities.Acesso;
import com.fast.caixaMultibanco.Entities.AuxAcesso;
import com.fast.caixaMultibanco.Entities.AuxLogin;
import com.fast.caixaMultibanco.Entities.Caixa;
import com.fast.caixaMultibanco.Entities.Cliente;
import com.fast.caixaMultibanco.exception.EntitiesException;
import com.fast.caixaMultibanco.repositories.AcessoRepository;
import com.fast.caixaMultibanco.repositories.CaixaRepository;
import com.fast.caixaMultibanco.repositories.ClienteRepository;

import tools.Criptografar;

@RestController
@RequestMapping(value = "/banco")
public class UserController {

	private final ClienteRepository clienteRepositorio;
	private final CaixaRepository caixaRepositorio;
	private final AcessoRepository acessoRepositorio;


	/**
	 * 
	 * @author Maurilio
	 * @author allan
	 * @version 0.0.4
	 */	
	public UserController(ClienteRepository clienteRepositorio, CaixaRepository caixaRepositorio, AcessoRepository acessoRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
		this.caixaRepositorio = caixaRepositorio;
		this.acessoRepositorio = acessoRepositorio;
	}
	
	@PostMapping("/loginBanco")
	@ResponseBody
	AuxAcesso loginBanco(@RequestBody AuxLogin login) throws Exception {
		
		System.out.println(login);
		
		Acesso novoAcesso = new Acesso(null, null, null, null, null);
		Cliente cliente = this.one(login.getLogin());

		if(cliente.getSenha().equals( Criptografar.gerarHashMD5(login.getSenha()))) {
			if(cliente.getConta().equals(login.getConta())) {
				novoAcesso.setCaixa(login.getCaixa());
				novoAcesso.setCliente(cliente);
				Instant now = Instant.now();
				novoAcesso.setTempoInicial(now.toEpochMilli());
				novoAcesso.setTempoFinal();
				novoAcesso.setToken(Criptografar.gerartoken(novoAcesso.getCliente().getLogin()));
				cliente.setAcesso(novoAcesso);
				cliente.setDt_acesso(now);
				acessoRepositorio.save(novoAcesso);
				clienteRepositorio.save(cliente);
				AuxAcesso auxAcesso = new AuxAcesso();
				auxAcesso.setAcesso(novoAcesso.getToken());
				return auxAcesso;
			}
		}
		return null;
	}

	@PostMapping("/cliente")
	Cliente novoCliente(@RequestBody Cliente novoCliente) {
		return clienteRepositorio.save(novoCliente);
	}

	@GetMapping("/cliente/{id}")
	Cliente one(@PathVariable String id) {
		return clienteRepositorio.findById(id)
				.orElseThrow(() -> new EntitiesException("CLIENTE ID:" + id + " NÃO ENCONTRADO."));
	}

	@DeleteMapping("/cliente/{id}")
	void excluirCliente(@PathVariable String id) {
		clienteRepositorio.deleteById(id);
	}
	
	
	/*
	 * CAIXA NÃO PRECISA DE POST, PUT OU DELETE - POR ENQUANTO.
	 */

	@GetMapping("/caixa/{id}")
	Caixa buscarCaixa(@PathVariable Integer id) {
		return caixaRepositorio.findById(id)
				.orElseThrow(() -> new EntitiesException("CAIXA ID:" + id + " NÃO ENCONTRADO."));
	}
	


//	/**
//	 * 
//	 * @return Json com informação do cliente
//	 */
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public ResponseEntity<HashMap<String, String>> getUser() {
//
//		HashMap<String, String> clienteInformacao = new HashMap<>();
//		clienteInformacao.put("cliente", "thiago");
//		clienteInformacao.put("banco", "teste banco");
//		clienteInformacao.put("saldo", "10054");
//		return new ResponseEntity<HashMap<String, String>>(clienteInformacao, HttpStatus.OK);
//	}

}
