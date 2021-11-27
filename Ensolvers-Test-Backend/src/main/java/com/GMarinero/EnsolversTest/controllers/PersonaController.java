package com.GMarinero.EnsolversTest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GMarinero.EnsolversTest.entities.Person;
import com.GMarinero.EnsolversTest.repositories.PersonaDAO;

@RestController
public class PersonaController {

	@Autowired
	private PersonaDAO personRepo;
	
	@GetMapping("/person")
	//List<Person>
	ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personRepo.findAll());}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("-->[Error] " + ex.getMessage());}
	}
	
	@PostMapping("/person")
	//Person 
	ResponseEntity<?> savePerson(@RequestBody Person person) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personRepo.save(person));}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("-->[Error] " + ex.getMessage());
		}
	}
	
	@PutMapping("/person/{id}")
	ResponseEntity<?> updatePersona(@RequestBody Person person, @PathVariable Long id) {
		try {
			Optional<Person> currentPerson = personRepo.findById(id);
			Person updatedPerson = currentPerson.get();
			updatedPerson = personRepo.save(person);
			return ResponseEntity.status(HttpStatus.OK).body(personRepo.save(updatedPerson));
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("-->[Error] " + ex.getMessage());
		}
	}
	
	@DeleteMapping("/person/{id}")
	ResponseEntity<?> deletePerson(@PathVariable Long id) {
		try {
			if(personRepo.findById(id) != null) {
				personRepo.deleteById(id);
				return new ResponseEntity<>("Person founded and eliminated", HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>("The ID is not found", HttpStatus.NOT_FOUND);
			}
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("-->[Error] " + ex.getMessage());
		}
	}
}
