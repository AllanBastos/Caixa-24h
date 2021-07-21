package com.fast.caixaMultibanco;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


import org.junit.jupiter.api.Test;

import com.fast.caixaMultibanco.entidades.Caixa;

class CaixaSaqueTeste {

	public int[] criarCaixa(Double valor, int qtd_cedulas_2, int qtd_cedulas_5, int qtd_cedulas_10,
			int qtd_cedulas_50) {

		Caixa caixa = new Caixa(qtd_cedulas_2, qtd_cedulas_5, qtd_cedulas_10, qtd_cedulas_50);
		return caixa.calcularCedulas(valor);
	}

	@Test
	void testCalcularCedulas1() {

		// Sequencia de notas - 50, 10, 5, 2
		assertEquals("[0, 1, 0, 4]", Arrays.toString(criarCaixa(18.0, 10, 10, 10, 10)));
	}
	
	@Test
	void testCalcularCedulas2() {

		// Sequencia de notas - 50, 10, 5, 2
		assertEquals("[10, 0, 0, 0]", Arrays.toString(criarCaixa(500.0, 200, 200, 200, 200)));
	}
	
	@Test
	void testCalcularCedulas3() {

		// Sequencia de notas - 50, 10, 5, 2
		assertEquals("[0, 0, 0, 9]", Arrays.toString(criarCaixa(18.0, 10, 0, 0, 0)));
	}
	@Test
	void testCalcularCedulas4() {

		// Sequencia de notas - 50, 10, 5, 2
		assertEquals("null", Arrays.toString(criarCaixa(18.0, 10, 1, 0, 0)));
	}
	
	@Test
	void testCalcularCedulas5() {

		// Sequencia de notas - 50, 10, 5, 2
		assertEquals("[1, 4, 1, 4]", Arrays.toString(criarCaixa(103.0, 200, 200, 200, 200)));
	}

}
