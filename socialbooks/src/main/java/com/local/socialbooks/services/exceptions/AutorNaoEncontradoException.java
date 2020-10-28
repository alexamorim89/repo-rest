package com.local.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8277514938847547905L;
	
	
	public AutorNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	

	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
