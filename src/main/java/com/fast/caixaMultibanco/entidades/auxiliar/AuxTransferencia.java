/**
 * 
 */
package com.fast.caixaMultibanco.entidades.auxiliar;

import java.util.List;

import com.fast.caixaMultibanco.entidades.Cliente;

/**
 * @author Maurilio
 *
 */
public class AuxTransferencia {

	private AuxAcesso acesso;
	private Double valor;
	private String conta_destino;

	/**
	 * @return the acesso
	 */
	public AuxAcesso getAcesso() {
		return acesso;
	}

	/**
	 * @param acesso the acesso to set
	 */
	public void setAcesso(AuxAcesso acesso) {
		this.acesso = acesso;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the conta_destino
	 */
	public String getConta_destino() {
		return conta_destino;
	}

	/**
	 * @param conta_destino the conta_destino to set
	 */
	public void setConta_destino(String conta_destino) {
		this.conta_destino = conta_destino;
	}

	/**
	 * @return true encontrar cliente na lista;
	 */
	public Cliente contaDestino(List<Cliente> clientes, String conta_destino) {
		for (Cliente c : clientes) {
			if (c.getConta().equals(conta_destino)) {
				return c;
			}
		}
		return null;
	}

}
