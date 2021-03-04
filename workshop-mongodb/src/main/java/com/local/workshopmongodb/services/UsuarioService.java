package com.local.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.workshopmongodb.domain.Usuario;
import com.local.workshopmongodb.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	 
}
