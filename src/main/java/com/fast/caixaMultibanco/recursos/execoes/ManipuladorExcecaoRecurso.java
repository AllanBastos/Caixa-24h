package com.fast.caixaMultibanco.recursos.execoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fast.caixaMultibanco.services.excecoes.AcessoExcecao;
import com.fast.caixaMultibanco.services.excecoes.SaqueExcecao;
import com.fast.caixaMultibanco.services.excecoes.TempoExpiradoException;
import com.fast.caixaMultibanco.services.excecoes.RecursoNaoEncontradoExcecao;

@ControllerAdvice
public class ManipuladorExcecaoRecurso {

	@ExceptionHandler(RecursoNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoExcecao e, HttpServletRequest request ){
		String error = "conta, usuário ou senha inválidos(s): ";
		HttpStatus status = HttpStatus.valueOf(300);
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(),  request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	
	@ExceptionHandler(AcessoExcecao.class)
	public ResponseEntity<ErroPadrao> AcessoInvalido(AcessoExcecao e, HttpServletRequest request ){
		String error = "código de acesso inválido:";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(),  request.getRequestURI());	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> ErroAplicação(RuntimeException e, HttpServletRequest request ){
		String error = "Erro na aplicação";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;	
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(SaqueExcecao.class)
	public ResponseEntity<Object> ErroAplicação(SaqueExcecao e, HttpServletRequest request ){
		HttpStatus status = HttpStatus.MULTIPLE_CHOICES;	
		String error = "Falha no saque";
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(),  request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(TempoExpiradoException.class)
	public ResponseEntity<ErroPadrao> TempoEspirado(TempoExpiradoException e, HttpServletRequest request){
		String error = "Tempo Esgotado";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(),  request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
