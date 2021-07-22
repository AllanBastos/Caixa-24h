package com.fast.caixaMultibanco.services.excecoes;

public class SaqueExcecao extends RuntimeException {
	static final long serialVersionUID = 1L;
	
	public int tipo = 1;
	
	public SaqueExcecao(String msg, int tipo) {
		super(msg);
		this.tipo = tipo;
	}
	
	public SaqueExcecao(String msg) {
		super(msg);
		
	}
}
