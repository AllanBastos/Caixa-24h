package com.fast.caixaMultibanco.Entities;

<<<<<<< HEAD

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
=======
import java.security.MessageDigest;
import java.time.LocalDate;
>>>>>>> 23b38522d16e3b510b2d874f42ed20ee8f77d03f

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe Cliente, entidade que representa o cliente de um banco
 * 
 * @author allan
 * @version 0.0.4
 */

@Entity
public class Cliente {
	// Atributos

<<<<<<< HEAD
	
=======
>>>>>>> 23b38522d16e3b510b2d874f42ed20ee8f77d03f
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
	@Column()
	private String acesso; // código temporário para operações (alfanumérico de 64 caracteres).
<<<<<<< HEAD
	private Date dt_acesso; // data e hora da geração do acesso.
	
	
	
=======
	@Column()
	private LocalDate dt_acesso; // data e hora da geração do acesso.

>>>>>>> 23b38522d16e3b510b2d874f42ed20ee8f77d03f
	/**
	 * 
	 */
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
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
		this.senha = gerarHashMD5(senha);
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
	public String getAcesso() {
		return acesso;
	}

	/**
	 * @return the date and time of the access generation
	 */
	public java.util.Date getDt_acesso() {
		return dt_acesso;
	}

<<<<<<< HEAD

	/**
	 * @param dt_acesso the dt_acesso to set
	 * 
	 */
	public void setDt_acesso() throws ParseException {
		Calendar dataAtual = Calendar.getInstance();
		dt_acesso =  dataAtual.getTime();
	}
	
	
	
=======
	/**
	 * Author: Maurilio
	 * Criptografar senha com MD5
	 *
	 */
	private String gerarHashMD5(String senha) throws Exception {
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		byte hash[] = algorithm.digest(senha.getBytes("UTF-8"));
		StringBuilder texto = new StringBuilder();
		for (byte b : hash) {
			texto.append(String.format("%02X", 0xFF & b));
		}
		return texto.toString();
	}
>>>>>>> 23b38522d16e3b510b2d874f42ed20ee8f77d03f

}
