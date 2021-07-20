package com.fast.caixaMultibanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fast.caixaMultibanco.entidades.Banco;



/**
 * interface repositorio banco da Classe Banco
 * @author allan
 *
 */
public interface BancoRepositorio extends JpaRepository<Banco, Integer> {
	
}
