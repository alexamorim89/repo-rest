package com.local.api.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.api.model.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario usuario = new Usuario(1L, "Maria", "maria@gmail.com", "9 9999-9999", "123456");
		return ResponseEntity.ok().body(usuario);
	}
	
	
}