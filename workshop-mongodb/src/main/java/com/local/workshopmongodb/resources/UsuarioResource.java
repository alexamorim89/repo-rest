package com.local.workshopmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.local.workshopmongodb.domain.Post;
import com.local.workshopmongodb.domain.Usuario;
import com.local.workshopmongodb.dto.UsuarioDTO;
import com.local.workshopmongodb.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = this.usuarioService.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
		Usuario usuario = this.usuarioService.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioService.fromDTO(usuarioDTO);
		usuario = this.usuarioService.insert(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();		
		return ResponseEntity.created(uri).build();
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UsuarioDTO usuarioDTO, @PathVariable String id) {
		Usuario usuario = usuarioService.fromDTO(usuarioDTO);
		usuario.setId(id);
		usuarioService.update(usuario);		
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		Usuario usuario = this.usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario.getPosts());
	}	
	
}