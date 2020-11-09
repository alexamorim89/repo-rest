package com.local.api.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.local.api.services.exceptions.DataBaseException;
import com.local.api.services.exceptions.RecursoNaoEncontradoException;

@ControllerAdvice
public class RecursoExceptionHandler {
	
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<PadraoErro> recursoNaoEncontradoException(RecursoNaoEncontradoException e, HttpServletRequest request){
		String erro = "Recurso Nao encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		PadraoErro padraoError = new PadraoErro(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(padraoError);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<PadraoErro> DataBaseException(DataBaseException e, HttpServletRequest request){
		String erro = "DataBase Erro";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		PadraoErro padraoError = new PadraoErro(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(padraoError);
	}
	
}
