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
	
	public void delete(String id) {
		findById(id);
		usuarioRepository.deleteById(id);
	}
	
	public Usuario update(Usuario usuario) {
		Optional<Usuario> novoUsuario = usuarioRepository.findById(usuario.getId());
		if(!novoUsuario.isPresent()) {
			throw new ObjectNotFoundException("Objeto nao encontrado"); 
		}		
		updateData(novoUsuario.get(), usuario);
		return usuarioRepository.save(novoUsuario.get());
	}

	public Usuario fromDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
	}
	
	private void updateData(Usuario novoUsuario, Usuario usuario) {
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setEmail(usuario.getEmail());		
	}
	
}