package com.GMarinero.EnsolversTest.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GMarinero.EnsolversTest.entities.Person;
import com.GMarinero.EnsolversTest.repositories.PersonDAO;

@Service
public class PersonServiceImp implements PersonService{

	@Autowired
	private PersonDAO personDAO;
	
	@Override
	public Person createPerson(Person person) throws Exception {
		try {
			person = personDAO.save(person);
			return person;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<Person> findPersonById(Long id) throws Exception {
		try {
			Optional<Person> optionalPerson = personDAO.findById(id); 
			return optionalPerson;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Person> findAllPersons() throws Exception {
		try {
			List<Person> persons = personDAO.findAll(); 
			return persons;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public Person updatePerson(Long id, Person person) throws Exception {
		try {
			Optional<Person> optionalPerson = personDAO.findById(id);
			Person personUpdate = optionalPerson.get(); 
			personUpdate = personDAO.save(person);
			return personUpdate;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean deletePerson(Long id) throws Exception {
		try {
			if(personDAO.existsById(id)) { 	
				personDAO.deleteById(id);
				return true;
			}else {								
				throw new Exception();
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
