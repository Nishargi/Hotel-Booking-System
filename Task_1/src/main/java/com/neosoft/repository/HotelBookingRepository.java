package com.neosoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.entity.HotelBooking;

@Repository
public interface HotelBookingRepository extends MongoRepository<HotelBooking,Long> {

}
