package com.fast.caixaMultibanco.entidades;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Acesso {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	@OneToMany(mappedBy = "cliente" )
	@JsonIgnore
	private Cliente cliente;
	
	private String token;
	private Integer caixa;
	private Long tempoInicial;
	private Long tempoFinal;

	/**
	 * 
	 */
	public Acesso() {
		super();
	}
	
	

	/**
	 * @param cliente
	 * @param token
	 * @param caixa
	 * @param tempoInicial
	 * @param tempoFinal
	 */
	public Acesso(Cliente cliente, String token, Integer caixa, Long tempoInicial, Long tempoFinal) {
		super();
		this.cliente = cliente;
		this.token = token;
		this.caixa = caixa;
		this.tempoInicial = tempoInicial;
		this.tempoFinal = tempoFinal;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the token
	 */
	public String getToken() {
		return  token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the caixa
	 */
	public Integer getCaixa() {
		return caixa;
	}

	/**
	 * @param caixa the caixa to set
	 */
	public void setCaixa(Integer caixa) {
		this.caixa = caixa;
	}


	/**
	 * @return the fimTempo
	 */
	/**
	 * @return the tempoInicial
	 */
	public Long getTempoInicial() {
		return tempoInicial;
	}

	/**
	 * @param tempoInicial the tempoInicial to set
	 */
	public void setTempoInicial(Long tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	/**
	 * @return the tempoFinal
	 */
	public Long getTempoFinal() {
		return tempoFinal;
	}

	/**
	 * @param tempoFinal the tempoFinal to set
	 */
	public void setTempoFinal() {
		this.tempoFinal = getTempoInicial() + 60000;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caixa, cliente, id, tempoFinal, tempoInicial, token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Acesso))
			return false;
		Acesso other = (Acesso) obj;
		return Objects.equals(caixa, other.caixa) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(id, other.id) && Objects.equals(tempoFinal, other.tempoFinal)
				&& Objects.equals(tempoInicial, other.tempoInicial) && Objects.equals(token, other.token);
	}

	@Override
	public String toString() {
		return "Acesso [id=" + id + ", cliente=" + cliente + ", token=" + token + ", caixa=" + caixa + ", tempoInicial="
				+ tempoInicial + ", tempoFinal=" + tempoFinal + "]";
	}

	
	
	

}
