 package br.com.erudio.controller.vo.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v2.PersonVO2;
import br.com.erudio.service.v2.PersonServiceV2;

@RestController
@RequestMapping(value = "/person/v2")
public class PersonControllerVO2 {
	
	@Autowired
	private PersonServiceV2 personService;
	
	@GetMapping(value = "/{id}")
	public PersonVO2 findById(@PathVariable("id") Long id) throws Exception {		
		return personService.findById(id);	
	}
	
	@GetMapping
	public List<PersonVO2> findAll() throws Exception {		
		return personService.findAll();	
	}
	
	@PostMapping
	public PersonVO2 create(@RequestBody PersonVO2 personVO2) throws Exception {		
		return personService.create(personVO2);	
	}
	
	@PutMapping
	public PersonVO2 update(@RequestBody PersonVO2 personVO2) throws Exception {		
		return personService.update(personVO2);	
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {		
		personService.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}