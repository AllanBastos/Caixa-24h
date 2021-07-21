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

	public List<Caixa> findAll() {
		return repository.findAll();
	}

	public Caixa findById(Integer id) {
		Optional<Caixa> obj = repository.findById(id);

		return obj.get();
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

	public Caixa insert(Caixa novoCaixa) {
		return repository.save(novoCaixa);
	}

	public void atualizarCaixa(Caixa caixaAtualizado) {
		Caixa caixa = this.findById(caixaAtualizado.getCodigo_caixa());
		updateData(caixa, caixaAtualizado);
		repository.save(caixa);
	}

	private void updateData(Caixa caixa, Caixa caixaAtualizado) {
		caixa.setQtd_cedulas_50(caixaAtualizado.getQtd_cedulas_50());
		caixa.setQtd_cedulas_10(caixaAtualizado.getQtd_cedulas_10());
		caixa.setQtd_cedulas_5(caixaAtualizado.getQtd_cedulas_5());
		caixa.setQtd_cedulas_2(caixaAtualizado.getQtd_cedulas_2());
	}

}
