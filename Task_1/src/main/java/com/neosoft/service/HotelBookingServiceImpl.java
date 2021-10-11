package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.entity.HotelBooking;
import com.neosoft.repository.HotelBookingRepository;

@Service
public class HotelBookingServiceImpl implements HotelBookingService{

	@Autowired
	private HotelBookingRepository hotelBookingRepository;
	
	// To Get All Bookings From Documents
	@Override
	public List<HotelBooking> getAllBookings() {
		// TODO Auto-generated method stub
		return hotelBookingRepository.findAll();
	}

	//  To Book The Hotel
	@Override
	public HotelBooking bookHotel(HotelBooking hotelBooking) {
		// TODO Auto-generated method stub
		return hotelBookingRepository.save(hotelBooking);
	}

}
