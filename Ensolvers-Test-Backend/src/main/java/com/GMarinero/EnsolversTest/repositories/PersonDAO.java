package com.GMarinero.EnsolversTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GMarinero.EnsolversTest.entities.Person;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long>{

}
