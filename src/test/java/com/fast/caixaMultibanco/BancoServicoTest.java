package com.fast.caixaMultibanco;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import com.fast.caixaMultibanco.Servicos.BancoServico;

class BancoServicoTest {

	BancoServico banco = new BancoServico();

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

}
