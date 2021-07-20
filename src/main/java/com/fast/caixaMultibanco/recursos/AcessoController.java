package com.fast.caixaMultibanco.recursos;

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

import com.fast.caixaMultibanco.entidades.Acesso;
import com.fast.caixaMultibanco.services.AcessoServico;


@RestController
@RequestMapping(value = "/acesso")
public class AcessoController {

	@Autowired
	private AcessoServico service;
	
	@GetMapping
	public ResponseEntity<List<Acesso>> findAll() {
		List<Acesso> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Acesso> findById(@PathVariable Long id){
		Acesso obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@PostMapping
	Acesso novoAcesso(@RequestBody Acesso novoAcesso) {
		return service.insert(novoAcesso);
	}

	@DeleteMapping("/{id}")
	void excluirAcesso(@PathVariable Long id) {
		service.delete(id);
	}
}
