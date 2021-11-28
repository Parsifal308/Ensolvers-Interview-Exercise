package com.GMarinero.EnsolversTest.services;

import java.util.List;
import java.util.Optional;

import com.GMarinero.EnsolversTest.entities.Activity;

public interface ActivityService{
	public Activity createActivity(Activity activity) throws Exception;
	public Optional<Activity> findActivityById(Long id) throws Exception;
	public List<Activity> findAllActivities() throws Exception;
	public Activity updateActivity(Long id, Activity activity) throws Exception;
	public boolean deleteActivity(Long id) throws Exception;
}
