 package br.com.erudio.controller.vo.v1;

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

import br.com.erudio.data.vo.v1.PersonVO1;
import br.com.erudio.service.v1.PersonServiceV1;

@RestController
@RequestMapping(value = "/person/v1")
public class PersonControllerVO1 {
	
	@Autowired
	private PersonServiceV1 personService;
	
	@GetMapping(value = "/{id}", consumes = {"application/json", "application/xml"})
	public PersonVO1 findById(@PathVariable("id") Long id) throws Exception {		
		return personService.findById(id);	
	}
	
	@GetMapping(consumes = {"application/json", "application/xml"})
	public List<PersonVO1> findAll() throws Exception {		
		return personService.findAll();	
	}
	
	@PostMapping(
			produces = {"application/json", "application/xml"}, 
			consumes = {"application/json", "application/xml"})
	public PersonVO1 create(@RequestBody PersonVO1 personVO1) throws Exception {		
		return personService.create(personVO1);	
	}
	
	@PutMapping(
			produces = {"application/json", "application/xml"}, 
			consumes = {"application/json", "application/xml"})
	public PersonVO1 update(@RequestBody PersonVO1 personVO1) throws Exception {		
		return personService.update(personVO1);	
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {		
		personService.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}