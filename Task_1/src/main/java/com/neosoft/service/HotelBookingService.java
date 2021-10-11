package com.neosoft.service;

import java.util.List;

import com.neosoft.entity.HotelBooking;

public interface HotelBookingService {

	List<HotelBooking> getAllBookings();
	
	HotelBooking bookHotel(HotelBooking hotelBooking);
	
	
}
