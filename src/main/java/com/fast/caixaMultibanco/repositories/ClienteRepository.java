package com.fast.caixaMultibanco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fast.caixaMultibanco.Entities.Cliente;


/**
 * interface repositorio Cliente da Classe cliente
 * @author allan
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
