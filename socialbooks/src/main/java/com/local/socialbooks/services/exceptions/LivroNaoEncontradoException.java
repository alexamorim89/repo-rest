package com.local.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8277514938847547905L;
	
	
	public LivroNaoEncontradoException(String mensagem){
		super(mensagem);
	}
	

	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
