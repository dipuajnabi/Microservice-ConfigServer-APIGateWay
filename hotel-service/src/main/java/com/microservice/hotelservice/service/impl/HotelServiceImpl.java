package com.microservice.hotelservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotelservice.entity.Hotel;
import com.microservice.hotelservice.exception.ResouceNotFoundException;
import com.microservice.hotelservice.repository.HotelRepository;
import com.microservice.hotelservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResouceNotFoundException("Hotel not found with given hotelId"));
		
	}
	
	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}
	

}
