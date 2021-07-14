package com.fast.entidades;

//Código_caixa: gerado automáticamente;

public class Caixa {

	private static final int MAX_CEDULAS = 200;
	// Atributos
	private Integer codigo_caixa; //Código_caixa: gerado automáticamente;
	private int qtd_cedulas_2;
	private int qtd_cedulas_5;
	private int qtd_cedulas_10;
	private int qtd_cedulas_50;

	// Construtor
	public Caixa(int qtd_cedulas_2, int qtd_cedulas_5, int qtd_cedulas_10, int qtd_cedulas_50) {
		setQtd_cedulas_2(qtd_cedulas_2);
		setQtd_cedulas_5(qtd_cedulas_5);
		setQtd_cedulas_10(qtd_cedulas_10);
		setQtd_cedulas_50(qtd_cedulas_50);
		
	}

	public int getQtd_cedulas_2() {
		return qtd_cedulas_2;
	}

	public void setQtd_cedulas_2(int qtd_cedulas_2) {
		
		if (validarQuantidade(qtd_cedulas_2)) {
			this.qtd_cedulas_2 = qtd_cedulas_2;
		}else {
			throw new EntitiesException("Quantidades de cedulas invalidas");
		}
	}


	public int getQtd_cedulas_5() {
		return qtd_cedulas_5;
	}

	public void setQtd_cedulas_5(int qtd_cedulas_5) {
		if(validarQuantidade(qtd_cedulas_5)) {
			this.qtd_cedulas_5 = qtd_cedulas_5;
		}else {
			throw new EntitiesException("Quantidades de cedulas invalidas");
		}
	}

	public int getQtd_cedulas_10() {
		return qtd_cedulas_10;
	}

	public void setQtd_cedulas_10(int qtd_cedulas_10) {
		if(validarQuantidade(qtd_cedulas_10)) {
			this.qtd_cedulas_10 = qtd_cedulas_10;
		}else {
			throw new EntitiesException("Quantidades de cedulas invalidas");
		}
	}

	public int getQtd_cedulas_50() {
		return qtd_cedulas_50;
	}

	public void setQtd_cedulas_50(int qtd_cedulas_50) {
		if(validarQuantidade(qtd_cedulas_50)) {
			this.qtd_cedulas_5 = qtd_cedulas_50;
		}else {
			throw new EntitiesException("Quantidades de cedulas invalidas");
		}	
	}
	
	private boolean validarQuantidade(int qtd_cedulas) {
		if ( qtd_cedulas <= MAX_CEDULAS & qtd_cedulas >= 0) {			
			return true;
		}
		return false;
	}
	
}
