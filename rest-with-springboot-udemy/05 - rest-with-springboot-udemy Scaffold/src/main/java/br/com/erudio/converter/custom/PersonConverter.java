package br.com.erudio.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v2.PersonVO2;

@Service
public class PersonConverter {

	public PersonVO2 convertEntityToVO(Person person) {
		PersonVO2 vo = new PersonVO2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVOToEntity(PersonVO2 personVO2) {
		Person entity = new Person(); //entidade
		entity.setId(personVO2.getId());
		entity.setAddress(personVO2.getAddress());
		entity.setFirstName(personVO2.getFirstName());
		entity.setLastName(personVO2.getLastName());
		entity.setGender(personVO2.getGender());
		return entity;
	}
	
}
