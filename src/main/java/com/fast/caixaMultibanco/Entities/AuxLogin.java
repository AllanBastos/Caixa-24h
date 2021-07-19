package com.fast.caixaMultibanco.Entities;

import java.util.Objects;

public class AuxLogin {

	private String login;
	private String senha;
	private Integer caixa;
	private String conta;
	
	public AuxLogin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param login
	 * @param senha
	 * @param caixa
	 * @param conta
	 */
	public AuxLogin(String login, String senha, Integer caixa, String conta) {
		super();
		this.login = login;
		this.senha = senha;
		this.caixa = caixa;
		this.conta = conta;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the caixa
	 */
	public Integer getCaixa() {
		return caixa;
	}

	/**
	 * @param caixa the caixa to set
	 */
	public void setCaixa(Integer caixa) {
		this.caixa = caixa;
	}

	/**
	 * @return the conta
	 */
	public String getConta() {
		return conta;
	}

	/**
	 * @param conta the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "auxLogin [login=" + login + ", senha=" + senha + ", caixa=" + caixa + ", conta=" + conta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(caixa, conta, login, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AuxLogin))
			return false;
		AuxLogin other = (AuxLogin) obj;
		return Objects.equals(caixa, other.caixa) && Objects.equals(conta, other.conta)
				&& Objects.equals(login, other.login) && Objects.equals(senha, other.senha);
	}
	
	

}
