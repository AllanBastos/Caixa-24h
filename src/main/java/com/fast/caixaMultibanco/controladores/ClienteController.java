package com.fast.caixaMultibanco.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fast.caixaMultibanco.entidades.Cliente;
import com.fast.caixaMultibanco.services.ClienteServico;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteServico service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable String id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@PostMapping
	Cliente novoCliente(@RequestBody Cliente novoCliente) {
		return service.insert(novoCliente);
	}

	@DeleteMapping("/cliente/{id}")
	void excluirCliente(@PathVariable String id) {
		service.delete(id);
	}
}
