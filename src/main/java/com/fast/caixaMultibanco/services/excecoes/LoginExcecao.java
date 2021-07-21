/**
 * 
 */
package com.fast.caixaMultibanco.services.excecoes;

/**
 * @author Maurilio
 *
 */
public class LoginExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LoginExcecao(String msg) {
		super(msg);
	}

}
