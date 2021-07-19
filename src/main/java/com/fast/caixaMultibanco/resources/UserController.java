/**
 * 
 */
package com.fast.caixaMultibanco.resources;

import java.util.Calendar;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fast.caixaMultibanco.Entities.Acesso;
import com.fast.caixaMultibanco.Entities.Caixa;
import com.fast.caixaMultibanco.Entities.Cliente;
import com.fast.caixaMultibanco.exception.EntitiesException;
import com.fast.caixaMultibanco.repositories.CaixaRepository;
import com.fast.caixaMultibanco.repositories.ClienteRepository;

import tools.Criptografar;

@RestController
@RequestMapping(value = "/banco")
public class UserController {

	private final ClienteRepository clienteRepositorio;
	private final CaixaRepository caixaRepositorio;
	private Acesso acesso;

	/**
	 * 
	 * @author Maurilio
	 * @version 0.0.1
	 */	
	public UserController(ClienteRepository clienteRepositorio, CaixaRepository caixaRepositorio) {
		this.clienteRepositorio = clienteRepositorio;
		this.caixaRepositorio = caixaRepositorio;
	}
	
	@PostMapping("/loginBanco")
	String loginBanco(@RequestBody Acesso novoAcesso) throws Exception {
		Cliente cliente = this.one(novoAcesso.getLogin());
		Caixa caixa = this.buscarCaixa(novoAcesso.getCaixa());
		if(cliente.getSenha().equals(novoAcesso.getSenha())) {
			if(cliente.getConta().equals(novoAcesso.getConta())) {
				acesso = novoAcesso;
				acesso.setTempoInicial(Calendar.getInstance().getTimeInMillis());
				acesso.setTempoFinal();
				System.out.println(acesso.getTempoInicial());
				System.out.println(acesso.getTempoFinal());
				acesso.setToken(Criptografar.gerartoken(acesso.getLogin()));
				System.out.println("ACESSO PERMITIDO");
				System.out.println(acesso.getToken());
				return acesso.getToken();
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
