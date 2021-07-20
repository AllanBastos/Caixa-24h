package com.fast.caixaMultibanco.services.excecoes;

public class SaqueExcecao extends RuntimeException {
	static final long serialVersionUID = 1L;

	public SaqueExcecao(String msg) {
		super(msg);
	}
}
