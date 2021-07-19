package com.fast.caixaMultibanco.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import tools.Criptografar;

@Entity
public class Acesso {

	@Id	
	private String token;
	private String login;
	private String senha;
	private Integer caixa;
	private String conta;
	private Long tempoInicial;
	private Long tempoFinal;

	/**
	 * 
	 */
	public Acesso() {
		super();
	}

//	/**
//	 * @return the id
//	 */
//	public Long getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(Long id) {
//		this.id = id;
//	}

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
	 * @throws Exception
	 */
	public void setSenha(String senha) throws Exception {
		this.senha = Criptografar.gerarHashMD5(senha);
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return  token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
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

	/**
	 * @return the fimTempo
	 */
	/**
	 * @return the tempoInicial
	 */
	public Long getTempoInicial() {
		return tempoInicial;
	}

	/**
	 * @param tempoInicial the tempoInicial to set
	 */
	public void setTempoInicial(Long tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	/**
	 * @return the tempoFinal
	 */
	public Long getTempoFinal() {
		return tempoFinal;
	}

	/**
	 * @param tempoFinal the tempoFinal to set
	 */
	public void setTempoFinal() {
		this.tempoFinal = getTempoInicial() + 4000;
	}

	
	
	

}
