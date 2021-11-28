package com.GMarinero.EnsolversTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GMarinero.EnsolversTest.entities.Activity;

public interface ActivityDAO extends JpaRepository<Activity, Long>{

}
