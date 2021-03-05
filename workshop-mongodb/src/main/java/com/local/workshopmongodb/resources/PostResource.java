package com.local.workshopmongodb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.workshopmongodb.domain.Post;
import com.local.workshopmongodb.resources.uti.URL;
import com.local.workshopmongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = this.postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value = "/titulosearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value="texto", defaultValue = "") String texto) {
		texto = URL.decodeParam(texto);
		List<Post> list = postService.findByTitulo(texto);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="texto", defaultValue = "") String texto,
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate) {
		texto = URL.decodeParam(texto);
		Date min = URL.covertDate(minDate, new Date(0L));
		Date max = URL.covertDate(maxDate, new Date());
		
		List<Post> list = postService.fullSearch(texto, min, max);
		return ResponseEntity.ok().body(list);
	}
	
}