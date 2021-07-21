package com.fast.caixaMultibanco.services.excecoes;

public class TempoExpiradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TempoExpiradoException() {
		super("Tempo Expirado: Faça o login novemente!");
	}

}
