package com.fast.caixaMultibanco.recursos.execoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fast.caixaMultibanco.services.excecoes.AcessoExcecao;
import com.fast.caixaMultibanco.services.excecoes.recursoNaoEncontradoExcecao;

@ControllerAdvice
public class ManipuladorExcecaoRecurso {
	
	@ExceptionHandler(recursoNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(recursoNaoEncontradoExcecao e, HttpServletRequest request ){
		String error = "conta, usuário ou senha inválidos(s): ";
		HttpStatus status = HttpStatus.valueOf(300);
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(),  request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	
	@ExceptionHandler(AcessoExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(AcessoExcecao e, HttpServletRequest request ){
		String error = "código de acesso inválido:";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(),  request.getRequestURI());	
		return ResponseEntity.status(status).body(err);
	}
}
