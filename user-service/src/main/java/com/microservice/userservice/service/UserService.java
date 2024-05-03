package com.microservice.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.userservice.entity.Rating;
import com.microservice.userservice.entity.User;


public interface UserService {
	
	public User createUser(User user);
	
	public User getUser(String userId);
	
	public List<User> getAllUser();
	
	public User updateUser(User user, String userId);
	
	public Rating createRating(Rating rating);


}
