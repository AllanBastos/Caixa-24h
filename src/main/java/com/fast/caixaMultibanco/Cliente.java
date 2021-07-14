package com.fast.caixaMultibanco;

import java.time.LocalDate;

public class Cliente {
	// Atributos
	private String nome_cliente; // Obrigatório.
	private String telefone_cliente; // Opcional.
	private String login; // Obrigatório.
	private String senha; // Obrigatório, Criptografar com MD5.

	private int codigo_banco; // Obrigatório - consultar a tabela BACEN (3 numeros);
	private String nome_banco; // [Obrigatório]
	private String conta; // [Obrigatório]
	private Double saldo; // [Obrigatório] valor decimal com o saldo da conta do cliente;
	private String acesso; // código temporário para operações (alfanumérico de 64 caracteres).
	private LocalDate dt_acesso; // data e hora da geração do acesso.

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

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getTelefone_cliente() {
		return telefone_cliente;
	}

	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}

}
