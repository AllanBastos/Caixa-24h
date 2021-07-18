package com.fast.caixaMultibanco.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fast.caixaMultibanco.exception.EntitiesException;

/**
 * Classe Caixa
 * @author allan
 * @version 0.0.5
 */

//Código_caixa: gerado automáticamente;


@Entity
@Table(name="Caixa")
public class Caixa {

	private static final int MAX_CEDULAS = 200;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo", nullable = false)
	private Integer codigo_caixa; //Código_caixa: gerado automáticamente;
	
	private int qtd_cedulas_2;
	
	private int qtd_cedulas_5;
	
	private int qtd_cedulas_10;
	
	private int qtd_cedulas_50;
	
	/*
	 * Construtores
	 */
	public Caixa() {
		setQtd_cedulas_2(MAX_CEDULAS);
		setQtd_cedulas_5(MAX_CEDULAS);
		setQtd_cedulas_10(MAX_CEDULAS);
		setQtd_cedulas_50(MAX_CEDULAS);
	}

	public Caixa(int qtd_cedulas_2, int qtd_cedulas_5, int qtd_cedulas_10, int qtd_cedulas_50) {
		setQtd_cedulas_2(qtd_cedulas_2);
		setQtd_cedulas_5(qtd_cedulas_5);
		setQtd_cedulas_10(qtd_cedulas_10);
		setQtd_cedulas_50(qtd_cedulas_50);

	}
	
	/**
	 * @return the qtd_cedulas_2
	 */
	public int getQtd_cedulas_2() {
		return qtd_cedulas_2;
	}
	
	/**
	 * @param qtd_cedulas_2 the qtd_cedulas_2 to set
	 */
	public void setQtd_cedulas_2(int qtd_cedulas_2) {
		
		if (validarQuantidade(qtd_cedulas_2)) {
			this.qtd_cedulas_2 = qtd_cedulas_2;
		}else {
			throw new EntitiesException("Quantidades de cedulas invalidas");
		}
	}

	
	/**
	 * @return the qtd_cedulas_5
	 */
	public int getQtd_cedulas_5() {
		return qtd_cedulas_5;
	}

	
	/**
	 * @param qtd_cedulas_5 the qtd_cedulas_5 to set
	 */
	public void setQtd_cedulas_5(int qtd_cedulas_5) {
		if(validarQuantidade(qtd_cedulas_5)) {
			this.qtd_cedulas_5 = qtd_cedulas_5;
		}else {
			throw new EntitiesException("Quantidades de cedulas invalidas");
		}
	}

	/**
	 * @return the qtd_cedulas_10
	 */
	public int getQtd_cedulas_10() {
		return qtd_cedulas_10;
	}
	
	
	/**
	 * @param qtd_cedulas_10 the qtd_cedulas_10 to set
	 */
	public void setQtd_cedulas_10(int qtd_cedulas_10) {
		if(validarQuantidade(qtd_cedulas_10)) {
			this.qtd_cedulas_10 = qtd_cedulas_10;
		}else {
			throw new EntitiesException("Quantidades de cedulas invalidas");
		}
	}
	
	/**
	 * @return the qtd_cedulas_50
	 */
	public int getQtd_cedulas_50() {
		return qtd_cedulas_50;
	}
	
	/**
	 * @param qtd_cedulas_50 the qtd_cedulas_50 to set
	 */
	public void setQtd_cedulas_50(int qtd_cedulas_50) {
		if(validarQuantidade(qtd_cedulas_10)) {
			this.qtd_cedulas_50 = qtd_cedulas_50;
		}else {
			throw new EntitiesException("Quantidades de cedulas invalidas");
		}	
	}
	
	
	/**
	 * @return codigo_caixa the codigo_caixa to set
	 */
	public Integer getCodigo_caixa() {
		return codigo_caixa;
	}


	/**
	 * @return boolean the valid the number of banknotes
	 */
	private boolean validarQuantidade(int qtd_cedulas) {
		if ( qtd_cedulas <= MAX_CEDULAS & qtd_cedulas >= 0) {			
			return true;
		}
		return false;
	}
	
}
