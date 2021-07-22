package com.fast.caixaMultibanco.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fast.caixaMultibanco.entidades.excecao.EntitiesException;

/**
 * Classe Caixa
 * 
 * @author allan
 * @version 0.0.5
 */

//Código_caixa: gerado automáticamente;

@Entity
@Table(name = "Caixa")
public class Caixa {

	private static final int MAX_CEDULAS = 200;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", nullable = false)
	private Integer codigo_caixa; // Código_caixa: gerado automáticamente;

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
		} else {
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
		if (validarQuantidade(qtd_cedulas_5)) {
			this.qtd_cedulas_5 = qtd_cedulas_5;
		} else {
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
		if (validarQuantidade(qtd_cedulas_10)) {
			this.qtd_cedulas_10 = qtd_cedulas_10;
		} else {
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
		if (validarQuantidade(qtd_cedulas_10)) {
			this.qtd_cedulas_50 = qtd_cedulas_50;
		} else {
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
		if (qtd_cedulas <= MAX_CEDULAS & qtd_cedulas >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * Author: Maurilio
	 * 
	 * @return boolean. Verifica se o cliente tem saldo suficiente.
	 */
	public boolean verificarSaldoSuficiente(Double valor, Cliente cliente) {
		if (cliente.getSaldo() >= valor) {
			return true;
		}
		return false;
	}

	/**
	 * Author: Maurilio. Realiza o saque e encadeia as regras.
	 * 
	 * @return void.
	 */
	public boolean saque(Double valor) {
		if (valorSuficienteCaixa(valor) && verificarCasaDecimal(valor) && valor >= 2) {
			int[] quantNotas = calcularCedulas(valor);
			if (quantNotas != null) {
				subtrairCedulas(quantNotas);
//				System.out.println("SAQUE REALIZADO.");
				return true;
			} else {
//				System.out.println("QUANTIDADE DE CÉDULAS NÃO É O SUFICIENTE PARA ESSA OPERAÇÃO.");
				return false;
			}

		} else {
//			 System.out.println(" VALOR INDISPONÍVEL, PROCURE OUTRO CAIXA."); 
			return false;
		}

	}

	/* CAIXA CHEIO R$13.400 */
	/**
	 * Author: Maurilio
	 * 
	 * @return array de inteiros, com a quantidade de cada cédula usada. Verifica se o caixa tem a quantidade de cédulas
	 *         necessárias. Se não houver a quantidade necessária, retorna null.
	 */
	public int[] calcularCedulas(Double valor) {
		int[] quantCedulas = { 0, 0, 0, 0 };
		while (valor != 0) {
			if (quantCedulas[0] < getQtd_cedulas_50() && (valor >= 50 && valor != 51 && valor != 53)) {
				if (valor >= 50 && valor != 51) {
					quantCedulas[0] += 1;
					valor -= 50;
				}
			} else if (quantCedulas[1] < getQtd_cedulas_10() && (valor >= 10 && valor != 11 && valor != 13)) {
				if (valor >= 10 && valor != 11) {
					quantCedulas[1] += 1;
					valor -= 10;
				}
			} else if (quantCedulas[2] < getQtd_cedulas_5() && (valor >= 5 && valor != 6 && valor != 8)) {
				if (valor >= 5 && valor != 6) {
					quantCedulas[2] += 1;
					valor -= 5;
				}
			} else if (quantCedulas[3] < getQtd_cedulas_2() && (valor >= 2) && ((valor % 2 ) == 0)) {
				if (valor >= 2) {
					quantCedulas[3] += 1;
					valor -= 2;
				}
			} else if (valor != 0) {
				return null;
			}
		}
		System.out.println(quantCedulas);
		return quantCedulas;
	}

	/**
	 * Author: Maurilio
	 * 
	 * @return void. Subtrai a quantidade de cédulas necessárias do caixa.
	 */
	private void subtrairCedulas(int[] cedulasUsadas) {
		this.setQtd_cedulas_50(getQtd_cedulas_50() - cedulasUsadas[0]);
		this.setQtd_cedulas_10(getQtd_cedulas_10() - cedulasUsadas[1]);
		this.setQtd_cedulas_5(getQtd_cedulas_5() - cedulasUsadas[2]);
		this.setQtd_cedulas_2(getQtd_cedulas_2() - cedulasUsadas[3]);
	}

	/**
	 * Author: Maurilio
	 * 
	 * @return boolean. Verifica se há dinheiro suficiente no caixa, valor bruto.
	 */
	private boolean valorSuficienteCaixa(Double valor) {
		double valorTotal = ((this.qtd_cedulas_50 * 50.0) + (this.qtd_cedulas_10 * 10.0) + (this.qtd_cedulas_5 * 5.0)
				+ (this.qtd_cedulas_2 * 2.0));
		if (valorTotal < valor) {
			return false;
		}
		return true;
	}

	/**
	 * Author: Maurilio
	 * 
	 * @return boolean. Verifica se o valor tem casas decimais igual a 0.
	 */
	public boolean verificarCasaDecimal(Double valor) {
		double num = valor;
		double decimal = num % 1;
		if (decimal != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Caixa [codigo_caixa=" + codigo_caixa + ", qtd_cedulas_2=" + qtd_cedulas_2 + ", qtd_cedulas_5="
				+ qtd_cedulas_5 + ", qtd_cedulas_10=" + qtd_cedulas_10 + ", qtd_cedulas_50=" + qtd_cedulas_50 + "]";
	}

}
