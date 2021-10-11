package com.neosoft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.HotelBooking;
import com.neosoft.service.HotelBookingServiceImpl;

@RestController
public class HotelBookingController {

	@Autowired
	private HotelBookingServiceImpl hotelBookingImpl;
	
	// http://localhost:8080/bookHotel
	@PostMapping("/bookHotel")
	@PreAuthorize("hasRole('User')")
	public String saveUser(@Valid @RequestBody HotelBooking hotelBooking) {
		hotelBookingImpl.bookHotel(hotelBooking);
		return "Hotel Booked for : " 
				+ hotelBooking.getFirstName()+" "+hotelBooking.getLastName()+" "
						+ "with Id : "+hotelBooking.getId();
	}
	
	// http://localhost:8080/viewBookings
	@GetMapping("/viewBookings")
	@PreAuthorize("hasRole('Admin')")
	public List<HotelBooking> getAllBookings() {
		return hotelBookingImpl.getAllBookings();
	}
	
	/*
	// http://localhost:8080/viewBooking/{id}
	@GetMapping("/viewBooking/{id}")
	@PreAuthorize("hasRole('Admin')")
	public HotelBooking getBookingById(@PathVariable Long id) {
		return hotelBookingImpl.getBookingById(id);
	}*/
}
