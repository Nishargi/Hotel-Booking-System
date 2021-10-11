package com.neosoft.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

	private String userName;
	private String userEmail;
    private String userPassword;

}
