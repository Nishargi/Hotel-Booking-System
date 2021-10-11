package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entity.JwtRequest;
import com.neosoft.entity.JwtResponse;
import com.neosoft.service.JwtService;

@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;

    // http://localhost:8080/authenticate
    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
