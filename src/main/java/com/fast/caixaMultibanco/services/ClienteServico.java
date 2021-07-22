package com.fast.caixaMultibanco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fast.caixaMultibanco.entidades.Cliente;
import com.fast.caixaMultibanco.repositorios.ClienteRepositorio;
import com.fast.caixaMultibanco.services.excecoes.RecursoNaoEncontradoExcecao;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(String id) {
		Optional<Cliente> obj = repository.findById(id);

		return obj.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
	}

	public void delete(String id) {
		repository.deleteById(id);
	}

	public Cliente insert(Cliente novoCliente) {
		System.out.println(novoCliente);
		return repository.save(novoCliente);

	}

	public Cliente update(String id, Cliente obj) {
		@SuppressWarnings("deprecation")
		Cliente entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);

	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome_cliente(obj.getNome_cliente());
		entity.setTelefone_cliente(obj.getTelefone_cliente());

	}

	public Cliente receberSaldo(String id, Double valor) {
		@SuppressWarnings("deprecation")
		Cliente entity = repository.getOne(id);
		entity.setSaldo(entity.getSaldo() + valor);
		return repository.save(entity);
	}

	public Cliente debitarSaldo(String id, Double valor) {
		@SuppressWarnings("deprecation")
		Cliente entity = repository.getOne(id);
		entity.setSaldo(entity.getSaldo() - valor);
		return repository.save(entity);
	}

}
