package com.fast.caixaMultibanco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fast.caixaMultibanco.entidades.Cliente;


/**
 * interface repositorio Cliente da Classe cliente
 * @author allan
 *
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, String>{

}
