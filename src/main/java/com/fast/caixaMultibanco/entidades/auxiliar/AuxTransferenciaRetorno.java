/**
 * 
 */
package com.fast.caixaMultibanco.entidades.auxiliar;

/**
 * @author Maurilio
 *
 */
public class AuxTransferenciaRetorno {
	
	private String nome_cliente;
	private String conta;
	private Double valor_tranferido;
	private String nome_detinatario;
	private String conta_destinario;
	/**
	 * @param nome_cliente
	 * @param conta
	 * @param valor_tranferido
	 * @param nome_detinatario
	 * @param conta_destinario
	 */
	public AuxTransferenciaRetorno(String nome_cliente, String conta, Double valor_tranferido, String nome_detinatario,
			String conta_destinario) {
		super();
		this.nome_cliente = nome_cliente;
		this.conta = conta;
		this.valor_tranferido = valor_tranferido;
		this.nome_detinatario = nome_detinatario;
		this.conta_destinario = conta_destinario;
	}
	/**
	 * @return the nome_cliente
	 */
	public String getNome_cliente() {
		return nome_cliente;
	}
	/**
	 * @param nome_cliente the nome_cliente to set
	 */
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	/**
	 * @return the conta
	 */
	public String getConta() {
		return conta;
	}
	/**
	 * @param conta the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}
	/**
	 * @return the valor_tranferido
	 */
	public Double getValor_tranferido() {
		return valor_tranferido;
	}
	/**
	 * @param valor_tranferido the valor_tranferido to set
	 */
	public void setValor_tranferido(Double valor_tranferido) {
		this.valor_tranferido = valor_tranferido;
	}
	/**
	 * @return the nome_detinatario
	 */
	public String getNome_detinatario() {
		return nome_detinatario;
	}
	/**
	 * @param nome_detinatario the nome_detinatario to set
	 */
	public void setNome_detinatario(String nome_detinatario) {
		this.nome_detinatario = nome_detinatario;
	}
	/**
	 * @return the conta_destinario
	 */
	public String getConta_destinario() {
		return conta_destinario;
	}
	/**
	 * @param conta_destinario the conta_destinario to set
	 */
	public void setConta_destinario(String conta_destinario) {
		this.conta_destinario = conta_destinario;
	}

}
