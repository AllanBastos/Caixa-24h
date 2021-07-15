package com.fast.entidades;

import java.util.Date;

public class Banco {
	
	private int ISPB;
	private String nome_reduzido;
	private Integer codigo;
	private String compe;
	private String acesso_principal;
	private String nome_extenso;
	private Date inicio_da_operacao;
	
	
	public Banco(int iSPB, String nome_reduzido, Integer codigo, String compe, String acesso_principal,
			String nome_extenso, Date inicio_da_operacao) {
		super();
		ISPB = iSPB;
		this.nome_reduzido = nome_reduzido;
		this.codigo = codigo;
		this.compe = compe;
		this.acesso_principal = acesso_principal;
		this.nome_extenso = nome_extenso;
		this.inicio_da_operacao = inicio_da_operacao;
	}


	public String getNome_reduzido() {
		return nome_reduzido;
	}


	public void setNome_reduzido(String nome_reduzido) {
		this.nome_reduzido = nome_reduzido;
	}


	public String getCompe() {
		return compe;
	}


	public void setCompe(String compe) {
		this.compe = compe;
	}


	public String getAcesso_principal() {
		return acesso_principal;
	}


	public void setAcesso_principal(String acesso_principal) {
		this.acesso_principal = acesso_principal;
	}


	public String getNome_extenso() {
		return nome_extenso;
	}


	public void setNome_extenso(String nome_extenso) {
		this.nome_extenso = nome_extenso;
	}


	public int getISPB() {
		return ISPB;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public Date getInicio_da_operacao() {
		return inicio_da_operacao;
	}
	
	
	
	
	
}
