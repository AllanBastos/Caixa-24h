package com.fast.caixaMultibanco.Entities;

import java.text.ParseException;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import tools.Criptografar;

/**
 * Classe Cliente, entidade que representa o cliente de um banco
 * 
 * @author allan
 * @version 0.0.5
 */

@Entity
public class Cliente {
	// Atributos

	@Id
	@Column(nullable = false)
	private String login; // Obrigatório.
	@Column(nullable = false)
	private String nome_cliente; // Obrigatório.
	@Column
	private String telefone_cliente; // Opcional.
	@Column(nullable = false)
	private String senha; // Obrigatório, Criptografar com MD5.
	@Column(nullable = false)
	private int codigo_banco; // Obrigatório - consultar a tabela BACEN (3 numeros);
	@Column(nullable = false)
	private String nome_banco; // [Obrigatório]
	@Column(nullable = false)
	private String conta; // [Obrigatório]
	@Column(nullable = false)
	private Double saldo; // [Obrigatório] valor decimal com o saldo da conta do cliente;
	
	
	@OneToOne
	private Acesso acesso; // código temporário para operações (alfanumérico de 64 caracteres).
	
	@Column(nullable = true)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:ss'Z'", timezone = "GMT")
	private Instant dt_acesso; // data e hora da geração do acesso.
	private Instant dt_logout;

	/**
	 * 
	 */
	public Cliente() {
		super();
	}

	// Construtor
	public Cliente(String nome_cliente, String telefone_cliente, String login, String senha, int codigo_banco,
			String nome_banco, String conta, Double saldo) throws Exception {
		this.setNome_cliente(nome_cliente);
		this.setTelefone_cliente(telefone_cliente);
		this.setLogin(login);
		this.setSenha(senha);
		this.setCodigo_banco(codigo_banco);
		this.setNome_banco(nome_banco);
		this.setConta(conta);
		this.setSaldo(saldo);
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

//		this.senha = Criptografia:gerarHashMD5(senha);
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
	 * @param nome_banco the nome_banco to set
	 */
	public void setNome_banco(String nome_banco) {
		this.nome_banco = nome_banco;
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
	 * @param codigo_banco the codigo_banco to set
	 */
	public void setCodigo_banco(int codigo_banco) {
		this.codigo_banco = codigo_banco;
	}

	/**
	 * @return the saldo: decimal value with customer account balance
	 */
	public Double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the acesso: temporary code for operations
	 */
	public Acesso getAcesso() {
		return acesso;
	}

	public Instant getDt_acesso() {
		if (dt_acesso == null) {
			return null;
		}
		return dt_acesso;
	}

	/**
	 * @param dt_acesso the dt_acesso to set
	 * 
	 */
	public void setDt_acesso(Instant data) throws ParseException {
		dt_acesso = data;
	}
	

	public Instant getDt_logout() {
		return dt_logout;
	}

	public void setDt_logout() {
		this.dt_logout = Instant.ofEpochMilli(getDt_acesso().toEpochMilli() + 4000);
	}
	
	
	/**
	 * @param acesso the acesso to set
	 */
	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	/**
	 * @return the date and time of the access generation
	 */

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(acesso, other.acesso) && codigo_banco == other.codigo_banco
				&& Objects.equals(conta, other.conta) && Objects.equals(dt_acesso, other.dt_acesso)
				&& Objects.equals(login, other.login) && Objects.equals(nome_banco, other.nome_banco)
				&& Objects.equals(nome_cliente, other.nome_cliente) && Objects.equals(saldo, other.saldo)
				&& Objects.equals(senha, other.senha) && Objects.equals(telefone_cliente, other.telefone_cliente);
	}

}
