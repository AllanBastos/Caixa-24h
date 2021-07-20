package com.fast.caixaMultibanco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fast.caixaMultibanco.entidades.Caixa;
import com.fast.caixaMultibanco.repositorios.CaixaRepositorio;

@Service
public class CaixaServico {
	
	@Autowired
	private CaixaRepositorio repository;
	
	public List<Caixa> findAll(){
		return repository.findAll();
	}
	
	public Caixa findById(int id) {
		Optional<Caixa> obj = repository.findById(id);
		
		return obj.get();	
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public Caixa insert(Caixa novoCaixa) {
		return repository.save(novoCaixa);
	}


}
