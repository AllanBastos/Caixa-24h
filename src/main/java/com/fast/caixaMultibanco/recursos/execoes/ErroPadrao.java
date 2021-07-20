package com.fast.caixaMultibanco.recursos.execoes;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ErroPadrao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:ss'Z'", timezone = "GMT")
	private Instant timestap;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public ErroPadrao() {
	}


	/**
	 * @param timestap
	 * @param status
	 * @param error
	 * @param message
	 * @param path
	 */
	public ErroPadrao(Instant timestap, Integer status, String error, String message, String path) {
		super();
		this.timestap = timestap;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}


	/**
	 * @return the timestap
	 */
	public Instant getTimestap() {
		return timestap;
	}


	/**
	 * @param timestap the timestap to set
	 */
	public void setTimestap(Instant timestap) {
		this.timestap = timestap;
	}


	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}


	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}


	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}


	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
