package com.fast.caixaMultibanco;

//Código_caixa: gerado automáticamente;

public class Caixa {

	// Atributos
	private int qtd_cedulas_2;
	private int qtd_cedulas_5;
	private int qtd_cedulas_10;
	private int qtd_cedulas_50;

	// Construtor
	public Caixa(int qtd_cedulas_2, int qtd_cedulas_5, int qtd_cedulas_10, int qtd_cedulas_50) {
		this.qtd_cedulas_2 = qtd_cedulas_2;
		this.qtd_cedulas_5 = qtd_cedulas_5;
		this.qtd_cedulas_10 = qtd_cedulas_10;
		this.qtd_cedulas_50 = qtd_cedulas_50;
	}

	public int getQtd_cedulas_2() {
		return qtd_cedulas_2;
	}

	public void setQtd_cedulas_2(int qtd_cedulas_2) {
		this.qtd_cedulas_2 = qtd_cedulas_2;
	}

	public int getQtd_cedulas_5() {
		return qtd_cedulas_5;
	}

	public void setQtd_cedulas_5(int qtd_cedulas_5) {
		this.qtd_cedulas_5 = qtd_cedulas_5;
	}

	public int getQtd_cedulas_10() {
		return qtd_cedulas_10;
	}

	public void setQtd_cedulas_10(int qtd_cedulas_10) {
		this.qtd_cedulas_10 = qtd_cedulas_10;
	}

	public int getQtd_cedulas_50() {
		return qtd_cedulas_50;
	}

	public void setQtd_cedulas_50(int qtd_cedulas_50) {
		this.qtd_cedulas_50 = qtd_cedulas_50;
	}
}
