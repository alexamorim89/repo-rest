package com.local.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3648926402351146898L;


	public AutorExistenteException(String mensagem){
		super(mensagem);
	}
	

	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
