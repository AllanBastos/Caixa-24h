package com.fast.caixaMultibanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fast.caixaMultibanco.entidades.Caixa;



/**
 * Interface repositorio caixa da Classe Caixa
 * @author allan
 */
public interface CaixaRepositorio extends JpaRepository<Caixa, Integer> {

}
