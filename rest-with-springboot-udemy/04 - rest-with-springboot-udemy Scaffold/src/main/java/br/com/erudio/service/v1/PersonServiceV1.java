package br.com.erudio.service.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v1.PersonVO1;
import br.com.erudio.exception.ResourceNotFoundExpcetion;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServiceV1 {
	
	@Autowired
	private PersonRepository personRepository;
	
	public PersonVO1 create(PersonVO1 personVO) {
		var entity = DozerConverter.parseObject(personVO, Person.class);
		var  vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO1.class);
		return vo;
	}
	
	public PersonVO1 findById(Long id) {		
		var entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExpcetion("ID nao encontrado") );
		return DozerConverter.parseObject(entity, PersonVO1.class);		
	}
	
	public PersonVO1 update(PersonVO1 personVO) {
		var entity = personRepository.findById(personVO.getId())
				.orElseThrow(() -> new ResourceNotFoundExpcetion("ID nao encontrado") );
		
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());		
		
		var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO1.class);
		return vo;
	}
	
	
	public void delete(Long id) {
		Person personDelete = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExpcetion("ID nao encontrado") );
		personRepository.delete(personDelete);
	}
	
	
	public List<PersonVO1> findAll() {
		return DozerConverter.parseListObjects(personRepository.findAll(), PersonVO1.class);
	}

}