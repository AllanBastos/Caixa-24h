/**
 * 
 */
package com.fast.caixaMultibanco.Servicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fast.caixaMultibanco.entidades.Acesso;
import com.fast.caixaMultibanco.entidades.Caixa;
import com.fast.caixaMultibanco.entidades.Cliente;
import com.fast.caixaMultibanco.entidades.auxiliar.AuxSaqueCedulas;
import com.fast.caixaMultibanco.services.CaixaServico;
import com.fast.caixaMultibanco.services.excecoes.AcessoExcecao;

/**
 * @author Matheus-Thiago
 *
 */
@Service
public class ServicoClienteBanco {

//	@Autowired
//	private ClienteServico clienteServico;

	@Autowired
	private CaixaServico caixaServico;

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

	public Caixa retirarCedulaCaixa(Integer[] cedulasSaque, Caixa caixa) {

		for (Integer cedula : cedulasSaque) {

			if (cedula.equals(2)) {
				caixa.setQtd_cedulas_2(caixa.getQtd_cedulas_2() - 1);
			} else if (cedula.equals(5)) {
				caixa.setQtd_cedulas_5(caixa.getQtd_cedulas_5() - 1);
			} else if (cedula.equals(10)) {
				caixa.setQtd_cedulas_10(caixa.getQtd_cedulas_10() - 1);
			} else if (cedula.equals(50)) {
				caixa.setQtd_cedulas_50(caixa.getQtd_cedulas_50() - 1);
			} else {

			}

		}

		return caixa;

	}

	public ResponseEntity<AuxSaqueCedulas> saque(Cliente cliente, Acesso acesso, Integer valor) {

		Double saldo = cliente.getSaldo();

		if ((saldo.intValue() - valor) > 0) {

			Caixa caixa = caixaServico.findById(acesso.getCaixa());

			if (caixa == null) {
				throw new AcessoExcecao();
			}
			
			List<Integer> moedas = new ArrayList<>(Arrays.asList(2, 5, 10, 50));
			@SuppressWarnings("null")
			int[] quantidade = { caixa.getQtd_cedulas_2(), caixa.getQtd_cedulas_5(), caixa.getQtd_cedulas_10(),
					caixa.getQtd_cedulas_50() };

			Integer[] cedulasSaida = {};

			Integer[] cedulasSaque = saqueCedulas(valor, moedas, new Stack<>(), cedulasSaida, quantidade);
			
			if(cedulasSaque.length == 0) {
				throw new AcessoExcecao();
			} else {
				caixa = retirarCedulaCaixa(cedulasSaque, caixa);
				
				caixaServico.delete(caixa.getCodigo_caixa());
				caixaServico.insert(caixa);
			}
			AuxSaqueCedulas auxSaqueCedulas = new AuxSaqueCedulas();
			auxSaqueCedulas.setCodigo_banco(cliente.getCodigo_banco());
			auxSaqueCedulas.setConta(cliente.getConta());
			
			
			return ResponseEntity.ok().body(retornoSaque(cedulasSaque, auxSaqueCedulas));
		}

		return null;
	}
	
	public AuxSaqueCedulas retornoSaque(Integer[] cedulas, AuxSaqueCedulas auxSaqueCedulas) {
		
		for (Integer cedula : cedulas) {
			
			if (cedula.equals(2)) {
				auxSaqueCedulas.setCedulas_2(auxSaqueCedulas.getCedulas_2() + 1);
			} else if (cedula.equals(5)) {
				auxSaqueCedulas.setCedulas_5(auxSaqueCedulas.getCedulas_5() + 1);
			} else if (cedula.equals(10)) {
				auxSaqueCedulas.setCedulas_10(auxSaqueCedulas.getCedulas_10() + 1);
			} else if (cedula.equals(50)) {
				auxSaqueCedulas.setCedulas_50(auxSaqueCedulas.getCedulas_50() + 1);
			} else {

			}
		}
		return auxSaqueCedulas;
	}

}
