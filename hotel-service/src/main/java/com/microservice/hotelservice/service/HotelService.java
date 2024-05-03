package com.microservice.hotelservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.hotelservice.entity.Hotel;

@Service
public interface HotelService {
	
	Hotel saveHotel(Hotel hotel);
	Hotel getHotel(String hotelId);
	List<Hotel> getAllHotels();

}
