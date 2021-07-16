/**
 * 
 */
package com.fast.caixaMultibanco.resources;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	
	/**
	 * 
	 * @return Json com informação do cliente
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<HashMap<String, String>> getUser() {

		HashMap<String, String> clienteInformacao = new HashMap<>();
		clienteInformacao.put("cliente", "thiago");
		clienteInformacao.put("banco", "teste banco");
		clienteInformacao.put("saldo", "10054");
		return new ResponseEntity<HashMap<String, String>>(clienteInformacao, HttpStatus.OK);
	}

}
