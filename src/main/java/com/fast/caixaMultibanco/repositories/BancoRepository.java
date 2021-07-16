package com.fast.caixaMultibanco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fast.caixaMultibanco.Entities.Banco;



/**
 * interface repositorio banco da Classe Banco
 * @author allan
 *
 */
public interface BancoRepository extends JpaRepository<Banco, Integer> {
	
}
