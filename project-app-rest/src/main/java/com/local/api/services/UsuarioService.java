package com.local.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.local.api.model.entities.Usuario;
import com.local.api.model.repositories.UsuarioRepository;
import com.local.api.services.exceptions.DataBaseException;
import com.local.api.services.exceptions.RecursoNaoEncontradoException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id); 
		return usuario.orElseThrow(()-> new RecursoNaoEncontradoException(id)); 
	}
	
	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Long id, Usuario usuario) {
		Usuario entity = usuarioRepository.getOne(id);
		atualizaDados(entity, usuario);
		return usuarioRepository.save(entity);
	}
	
	public void delete(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}	
	
	private void atualizaDados(Usuario entity, Usuario usuario) {
		entity.setNome(usuario.getNome());
		entity.setEmail(usuario.getEmail());
		entity.setTelefone(usuario.getTelefone());
	}	
	
}