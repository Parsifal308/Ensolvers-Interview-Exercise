package com.GMarinero.EnsolversTest.services;

import java.util.List;
import java.util.Optional;

import com.GMarinero.EnsolversTest.entities.Person;

public interface PersonService {

	public Person createPerson(Person person) throws Exception;
	public Optional<Person> findPersonById(Long id) throws Exception;
	public List<Person> findAllPersons() throws Exception;
	public Person updatePerson(Long id, Person person) throws Exception;
	public boolean deletePerson(Long id) throws Exception;
}
