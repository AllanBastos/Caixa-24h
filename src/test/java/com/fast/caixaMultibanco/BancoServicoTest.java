package com.fast.caixaMultibanco;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import com.fast.caixaMultibanco.Servicos.ServicoClienteBanco;
import com.fast.caixaMultibanco.entidades.Caixa;

class BancoServicoTest {

	ServicoClienteBanco banco = new ServicoClienteBanco();

	@Test
	void testSaqueCedulasBasico() {
		int valor = 50; // valor do saque
		List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
		int[] quantidade = { 20, 20, 20, 20 };

		Integer[] cedulasSaida = {};

		Integer[] cedulas = banco.saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);

		assertEquals("[50]", Arrays.toString(cedulas));

	}

	@Test
	void testSaqueCedulas() {
		int valor = 22; // valor do saque
		List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
		int[] quantidade = { 20, 0, 0, 0 };

		Integer[] cedulasSaida = {};

		Integer[] cedulas = banco.saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);

		assertEquals("[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]", Arrays.toString(cedulas));

	}

	@Test
	void testSaqueCedulas1() {
		int valor = 22; // valor do saque
		List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
		int[] quantidade = { 20, 0, 10, 0 };

		Integer[] cedulasSaida = {};

		Integer[] cedulas = banco.saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);

		assertEquals("[2, 10, 10]", Arrays.toString(cedulas));

	}

	@Test
	void testSaqueCedulas2() {
		int valor = 22; // valor do saque
		List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
		int[] quantidade = { 20, 0, 10, 0 };

		Integer[] cedulasSaida = {};

		Integer[] cedulas = banco.saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);

		assertEquals("[2, 10, 10]", Arrays.toString(cedulas));

	}

	/**
	 * Teste para quantidade indisponível de cédulas Resultado - Array vazio
	 */
	@Test
	void testSaqueCedulas3() {
		int valor = 50; // valor do saque
		List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
		int[] quantidade = { 0, 0, 2, 0 };

		Integer[] cedulasSaida = {};

		Integer[] cedulas = banco.saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);

		assertEquals("[]", Arrays.toString(cedulas));

	}

	@Test
	void testSaqueCedulas4() {
		int valor = 150; // valor do saque
		List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
		int[] quantidade = { 0, 20, 20, 2 };

		Integer[] cedulasSaida = {};

		Integer[] cedulas = banco.saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);

		assertEquals("[10, 10, 10, 10, 10, 50, 50]", Arrays.toString(cedulas));

	}

	@Test
	void testSaqueCedulas5() {
		int valor = 13; // valor do saque
		List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
		int[] quantidade = { 20, 20, 20, 20 };

		Integer[] cedulasSaida = {};

		Integer[] cedulas = banco.saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);

		assertEquals("[2, 2, 2, 2, 5]", Arrays.toString(cedulas));

	}

	@Test
	void testSaqueCedulas6() {
		int valor = 8; // valor do saque
		List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
		int[] quantidade = { 20, 20, 20, 20 };

		Integer[] cedulasSaida = {};

		Integer[] cedulas = banco.saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);

		assertEquals("[2, 2, 2, 2]", Arrays.toString(cedulas));

	}
	
	@Test
	void retirarCedulaCaixa() {
		Integer[] cedulasSaque = {2,2,2,5,5,5,10,10,10,10,50,50};
		Caixa caixa = banco.retirarCedulaCaixa(cedulasSaque, new Caixa(200, 200, 200, 200));
		assertEquals("Caixa [codigo_caixa=null, qtd_cedulas_2=197, qtd_cedulas_5=197, qtd_cedulas_10=196, qtd_cedulas_50=198]", caixa.toString());
		
		
	}

}
