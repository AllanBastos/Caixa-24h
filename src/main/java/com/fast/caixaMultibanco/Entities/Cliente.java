package com.fast.caixaMultibanco.Entities;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe Cliente, entidade que representa o cliente de um banco
 * @author allan
 * @version 0.0.4
 */

@Entity
public class Cliente {
	// Atributos

	
	@Id
	private String login; // Obrigatório.
	private String nome_cliente; // Obrigatório.
	private String telefone_cliente; // Opcional.
	private String senha; // Obrigatório, Criptografar com MD5.
	private int codigo_banco; // Obrigatório - consultar a tabela BACEN (3 numeros);
	private String nome_banco; // [Obrigatório]
	private String conta; // [Obrigatório]
	private Double saldo; // [Obrigatório] valor decimal com o saldo da conta do cliente;
	private String acesso; // código temporário para operações (alfanumérico de 64 caracteres).
	private Date dt_acesso; // data e hora da geração do acesso.
	
	
	
	/**
	 * 
	 */
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	// Construtor
	public Cliente(String nome_cliente, String telefone_cliente, String login, String senha, int codigo_banco,
			String nome_banco, String conta, Double saldo) {
		this.nome_cliente = nome_cliente;
		this.telefone_cliente = telefone_cliente;
		this.login = login;
		this.senha = senha;
		this.codigo_banco = codigo_banco;
		this.nome_banco = nome_banco;
		this.conta = conta;
		this.saldo = saldo;
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
	
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * @return codigo_banco
	 */
	public int getCodigo_banco() {
		return codigo_banco;
	}
	
	/**
	 * @return the nome_banco
	 */
	public String getNome_banco() {
		return nome_banco;
	}
	
	/**
	 * @return the conta
	 */
	public String getConta() {
		return conta;
	}
	
	/**
	 * @return the saldo: decimal value with customer account balance
	 */
	public Double getSaldo() {
		return saldo;
	}
	
	
	/**
	 * @return the acesso: temporary code for operations
	 */
	public String getAcesso() {
		return acesso;
	}
	
	
	/**
	 * @return the date and time of the access generation
	 */
	public java.util.Date getDt_acesso() {
		return dt_acesso;
	}


	/**
	 * @param dt_acesso the dt_acesso to set
	 * 
	 */
	public void setDt_acesso() throws ParseException {
		Calendar dataAtual = Calendar.getInstance();
		dt_acesso =  dataAtual.getTime();
	}
	
	
	

}
