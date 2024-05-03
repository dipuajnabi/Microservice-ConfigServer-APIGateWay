package com.microservice.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userservice.entity.Rating;
import com.microservice.userservice.entity.User;
import com.microservice.userservice.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User savedUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	/*
	 * @GetMapping("{userId}")
	 * 
	 * @CircuitBreaker(name = "ratingHotelBreaker",
	 * fallbackMethod="ratingHotelFallBack") public ResponseEntity<User>
	 * getUser(@PathVariable String userId){
	 * logger.info("Get Single Handler: Usercontroller"); User user =
	 * userService.getUser(userId); return ResponseEntity.ok(user); }
	 * 
	 * public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex){
	 * logger.info("Fallback is executed because service is down: "+ex.getMessage())
	 * ; User user = User.builder() .email("dummy@gmail.com") .name("Dummy")
	 * .about("This user is created dummy because some serviceis down")
	 * .userId("141241") .build(); return new ResponseEntity<User>(user,
	 * HttpStatus.OK); }
	 */
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
	@PostMapping("{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String userId){
		User updateUser = userService.updateUser(user, userId);
		return ResponseEntity.ok(updateUser);
		
	}
	
	@PostMapping("/rating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating createRating = userService.createRating(rating);
		return ResponseEntity.ok(createRating);
	}

}
