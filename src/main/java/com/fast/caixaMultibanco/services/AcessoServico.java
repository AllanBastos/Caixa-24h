package com.fast.caixaMultibanco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fast.caixaMultibanco.entidades.Acesso;
import com.fast.caixaMultibanco.repositorios.AcessoRepositorio;

@Service
public class AcessoServico {
	
	@Autowired
	private AcessoRepositorio repository;
	
	public List<Acesso> findAll(){
		return repository.findAll();
	}
	
	public Acesso findById(Long id) {
		Optional<Acesso> obj = repository.findById(id);
		
		return obj.get();	
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Acesso insert(Acesso novoAcesso) {
		return repository.save(novoAcesso);
	}
	
}