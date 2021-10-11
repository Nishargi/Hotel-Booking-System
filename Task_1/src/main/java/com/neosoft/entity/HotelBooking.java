package com.neosoft.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "HotelBookings")
public class HotelBooking {

	@Id
	private Long id;
	
	@NotEmpty(message = "firstName must not be empty")
	private String firstName;
	
	@NotEmpty(message = "lastName must not be empty")
	private String lastName;

	@NotEmpty(message = "email must not be empty")
	@Email(message = "email should be a valid email")
	private String email;

	@NotEmpty(message = "mobile must not be empty")
	private String mobile;

	@NotEmpty(message = "from date must not be empty")
	private String from;

	@NotEmpty(message = "to date must not be empty")
	private String to;

	@NotEmpty(message = "special requirements must not be empty")
	private String specialRequest;	
}
