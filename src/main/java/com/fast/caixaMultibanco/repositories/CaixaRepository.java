package com.fast.caixaMultibanco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fast.caixaMultibanco.Entities.Caixa;



/**
 * Interface repositorio caixa da Classe Caixa
 * @author allan
 */
public interface CaixaRepository extends JpaRepository<Caixa, Integer> {

}
