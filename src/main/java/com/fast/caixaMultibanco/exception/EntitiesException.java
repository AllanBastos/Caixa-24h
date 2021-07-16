package com.fast.caixaMultibanco.exception;


/**
 * Classe de Exceção personalizada para criação de Entidades
 * @author allan
 * @version 0.0.1
 */

public class EntitiesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EntitiesException(String msg) {
		super(msg);
	}
	
	
}
