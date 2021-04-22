package br.com.erudio.service.v2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.converter.custom.PersonConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v2.PersonVO2;
import br.com.erudio.exception.ResourceNotFoundExpcetion;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServiceV2 {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonConverter personConverter;
	
	public PersonVO2 create(PersonVO2 personVO2) {
		var entity = personConverter.convertVOToEntity(personVO2);
		var  vo = personConverter.convertEntityToVO(personRepository.save(entity));
		return vo;
	}
	
	public PersonVO2 findById(Long id) {		
		var entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExpcetion("ID nao encontrado") );
		return DozerConverter.parseObject(entity, PersonVO2.class);		
	}
	
	public PersonVO2 update(PersonVO2 personVO2) {
		var entity = personRepository.findById(personVO2.getId())
				.orElseThrow(() -> new ResourceNotFoundExpcetion("ID nao encontrado") );
		
		entity.setFirstName(personVO2.getFirstName());
		entity.setLastName(personVO2.getLastName());
		entity.setAddress(personVO2.getAddress());
		entity.setGender(personVO2.getGender());		
		
		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO2.class);
		return vo;
	}
	
	
	public void delete(Long id) {
		Person personDelete = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExpcetion("ID nao encontrado") );
		personRepository.delete(personDelete);
	}
	
	
	public List<PersonVO2> findAll() {
		return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO2.class);
	}

}