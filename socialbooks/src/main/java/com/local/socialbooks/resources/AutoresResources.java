package com.local.socialbooks.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.local.socialbooks.domain.Autor;
import com.local.socialbooks.services.AutoresService;

@RestController
@RequestMapping("/autores")
public class AutoresResources {
	
	@Autowired
	private AutoresService autoresService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	public ResponseEntity<List<Autor>> listar(){
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);		
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(this.autoresService.listar());
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Autor autor){
		autor = this.autoresService.salvar(autor);
		
		//cria o cabeçalho location
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				   .buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Autor> buscar(@PathVariable("id") Long id){
		CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(this.autoresService.buscar(id)); 
	}
	
	
}
