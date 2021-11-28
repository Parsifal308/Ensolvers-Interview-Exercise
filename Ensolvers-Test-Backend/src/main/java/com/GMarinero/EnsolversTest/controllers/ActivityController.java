package com.GMarinero.EnsolversTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GMarinero.EnsolversTest.entities.Activity;
import com.GMarinero.EnsolversTest.services.ActivityService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "ensolvers/API/activities")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@GetMapping("")
	ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(activityService.findAllActivities());
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("-->[Error] " + ex.getMessage());
		}
	}
	
	@GetMapping("{id}")
	ResponseEntity<?> getById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(activityService.findActivityById(id));
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("-->[Error] " + ex.getMessage());
		}
	}
	
	@PostMapping("")
	ResponseEntity<?> savePerson(@RequestBody Activity activity) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(activityService.createActivity(activity));
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("-->[Error] " + ex.getMessage());
		}
	}
	
	@PutMapping("{id}")
	ResponseEntity<?> updatePersona(@RequestBody Activity activity, @PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(activityService.updateActivity(id, activity));
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("-->[Error] " + ex.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<?> deletePerson(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(activityService.deleteActivity(id));
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("-->[Error] " + ex.getMessage());
		}
	}
}
