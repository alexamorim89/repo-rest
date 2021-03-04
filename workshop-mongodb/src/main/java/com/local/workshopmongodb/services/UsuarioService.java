package com.local.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.workshopmongodb.domain.Usuario;
import com.local.workshopmongodb.dto.UsuarioDTO;
import com.local.workshopmongodb.repository.UsuarioRepository;
import com.local.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(String id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(!usuario.isPresent()) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}		
		return usuario.get();
	}
	
	public Usuario insert(Usuario usuario){
		return usuarioRepository.insert(usuario);
	}
	
	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
	}
	
}