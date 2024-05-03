package com.microservice.ratingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.ratingservice.entity.Rating;

@Service
public interface RatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getRatingByUserId(String ratingId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
	List<Rating> getAllRating();

}
