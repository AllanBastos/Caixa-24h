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

import com.fast.caixaMultibanco.entidades.Caixa;
import com.fast.caixaMultibanco.services.CaixaServico;


@RestController
@RequestMapping(value = "/caixa")
public class CaixaController {

	@Autowired
	private CaixaServico service;
	
	@GetMapping
	public ResponseEntity<List<Caixa>> findAll() {
		List<Caixa> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Caixa> findById(@PathVariable int id){
		Caixa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	@PostMapping
	Caixa novoCaixa(@RequestBody Caixa novoCaixa) {
		return service.insert(novoCaixa);
	}

	@DeleteMapping("/{id}")
	void excluirCaixa(@PathVariable int id) {
		service.delete(id);
	}
}
