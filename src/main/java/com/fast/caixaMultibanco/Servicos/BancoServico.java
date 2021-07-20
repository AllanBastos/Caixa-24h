/**
 * 
 */
package com.fast.caixaMultibanco.Servicos;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Matheus-Thiago
 *
 */
public class BancoServico {

	/**
	 * Este método retornar as cédulas do saque
	 * 
	 * @param valorSaque   - valor do saque
	 * @param cedulas      - Cédulas de referencia (2, 5, 10, 50) para saque
	 * @param pilha        - Estrutura de dados pilha usado para colocar as cédulas
	 * @param cedulasSaida - Estrutura de cédulas auxiliar usada para calcular o
	 *                     resultado
	 * @param quantidade   - Número de cédulas disponível
	 * @return Número de cédulas usada no saque. Retornando vazio caso não tenha
	 *         solução
	 */
	public Integer[] saqueCedulas(int valorSaque, List<Integer> cedulas, Stack<Integer> pilha, Integer[] cedulasSaida,
			int[] quantidade) {

		int[] quantidadeAux = Arrays.copyOf(quantidade, quantidade.length);
		if ((valorSaque < 0) || (cedulas.size() == 0))
			return cedulasSaida;
		if (valorSaque == 0) {

			Integer[] solAux = pilha.toArray(new Integer[pilha.size()]);
			boolean add = true;

			for (Integer z : solAux) {
				if (z.equals(2) && quantidadeAux[0] > 0) {
					quantidadeAux[0]--;
				} else if (z.equals(5) && quantidadeAux[1] > 0) {
					quantidadeAux[1]--;

				} else if (z.equals(10) && quantidadeAux[2] > 0) {
					quantidadeAux[2]--;

				} else if (z.equals(50) && quantidadeAux[3] > 0) {
					quantidadeAux[3]--;

				} else {
					add = false;
					break;
				}

			}
			if (add) {
				cedulasSaida = pilha.toArray(new Integer[pilha.size()]);

				return cedulasSaida;
			}

		}

		Integer dinheiro = cedulas.get(0);
		pilha.push(dinheiro);
		cedulasSaida = saqueCedulas(valorSaque - dinheiro, cedulas, pilha, cedulasSaida, quantidade);

		pilha.pop();

		List<Integer> moedas_novo = new ArrayList<>(cedulas);
		moedas_novo.remove(dinheiro);
		cedulasSaida = saqueCedulas(valorSaque, moedas_novo, pilha, cedulasSaida, quantidade);

		return cedulasSaida;
	}

}
