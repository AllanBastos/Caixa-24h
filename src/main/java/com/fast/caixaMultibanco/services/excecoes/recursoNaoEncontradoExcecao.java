package com.fast.caixaMultibanco.services.excecoes;

public class recursoNaoEncontradoExcecao extends RuntimeException {
	static final long serialVersionUID = 1L;

	public recursoNaoEncontradoExcecao(Object id) {
		super("Recurso não encontrado. Id " + id);
	}

}
