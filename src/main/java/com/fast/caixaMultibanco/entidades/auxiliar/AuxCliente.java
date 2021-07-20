package com.fast.caixaMultibanco.entidades.auxiliar;

public class AuxCliente {

	private String acesso;
	private String nome_cliente;
	private String telefone_cliente;
	
	public AuxCliente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param acesso
	 * @param nome_cliente
	 * @param telefone_cliente
	 */
	public AuxCliente(String acesso, String nome_cliente, String telefone_cliente) {
		super();
		this.acesso = acesso;
		this.nome_cliente = nome_cliente;
		this.telefone_cliente = telefone_cliente;
	}

	/**
	 * @return the acesso
	 */
	public String getAcesso() {
		return acesso;
	}

	/**
	 * @param acesso the acesso to set
	 */
	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	/**
	 * @return the nome_cliente
	 */
	public String getNome_cliente() {
		return nome_cliente;
	}

	/**
	 * @param nome_cliente the nome_cliente to set
	 */
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	/**
	 * @return the telefone_cliente
	 */
	public String getTelefone_cliente() {
		return telefone_cliente;
	}

	/**
	 * @param telefone_cliente the telefone_cliente to set
	 */
	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}

	
}
