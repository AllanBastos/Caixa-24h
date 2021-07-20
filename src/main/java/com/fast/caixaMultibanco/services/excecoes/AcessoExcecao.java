package com.fast.caixaMultibanco.services.excecoes;

public class AcessoExcecao extends RuntimeException {
	static final long serialVersionUID = 1L;

	public AcessoExcecao() {
		super("Acesso negado");
	}

}
