package com.fast.caixaMultibanco.services.excecoes;

public class RecursoNaoEncontradoExcecao extends RuntimeException {
	static final long serialVersionUID = 1L;

	public RecursoNaoEncontradoExcecao(Object id) {
		super("Recurso não encontrado. Id " + id);
	}

}
