package com.GMarinero.EnsolversTest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GMarinero.EnsolversTest.entities.Activity;
import com.GMarinero.EnsolversTest.repositories.ActivityDAO;

@Service
public class ActivityServiceImp implements ActivityService{

	@Autowired
	private ActivityDAO activityDAO;

	@Override
	public Activity createActivity(Activity activity) throws Exception {
		try {
			activity = activityDAO.save(activity);
			return activity;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<Activity> findActivityById(Long id) throws Exception {
		try {
			Optional<Activity> optionalActivity = activityDAO.findById(id); 
			return optionalActivity;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Activity> findAllActivities() throws Exception {
		try {
			List<Activity> activity = activityDAO.findAll(); 
			return activity;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	public Activity updateActivity(Long id, Activity activity) throws Exception {
		try {
			Optional<Activity> optionalActivity = activityDAO.findById(id);
			Activity personUpdate = optionalActivity.get();
			personUpdate = activityDAO.save(activity);
			return personUpdate;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean deleteActivity(Long id) throws Exception {
		try {
			if(activityDAO.existsById(id)) { 	
				activityDAO.deleteById(id);
				return true;
			}else {								
				throw new Exception();
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}


}
