package com.local.workshopmongodb.dto;

import java.io.Serializable;

import com.local.workshopmongodb.domain.Usuario;

public class AutorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;

	public AutorDTO() {
		// TODO Auto-generated constructor stub
	}

	public AutorDTO(Usuario autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}