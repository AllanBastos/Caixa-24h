package com.fast.caixaMultibanco.entidades.auxiliar;

public class AuxConsultaCliente {
	
	private int codigo_banco;
	private String nome_banco;
	private String nome_cliente;
	private String telefone_cliente;
	
	public AuxConsultaCliente() {
	}

	/**
	 * @param codigo_banco
	 * @param nome_banco
	 * @param nome_cliente
	 * @param telefone_cliente
	 */
	public AuxConsultaCliente(int codigo_banco, String nome_banco, String nome_cliente, String telefone_cliente) {
		super();
		this.codigo_banco = codigo_banco;
		this.nome_banco = nome_banco;
		this.nome_cliente = nome_cliente;
		this.telefone_cliente = telefone_cliente;
	}



	/**
	 * @return the codigo_banco
	 */
	public int getCodigo_banco() {
		return codigo_banco;
	}

	/**
	 * @param codigo_banco the codigo_banco to set
	 */
	public void setCodigo_banco(int codigo_banco) {
		this.codigo_banco = codigo_banco;
	}

	/**
	 * @return the nome_banco
	 */
	public String getNome_banco() {
		return nome_banco;
	}

	/**
	 * @param nome_banco the nome_banco to set
	 */
	public void setNome_banco(String nome_banco) {
		this.nome_banco = nome_banco;
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
