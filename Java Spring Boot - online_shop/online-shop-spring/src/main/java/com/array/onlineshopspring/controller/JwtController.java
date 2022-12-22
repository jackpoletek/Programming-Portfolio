package com.array.onlineshopspring.controller;

import com.array.onlineshopspring.model.JwtRequest;
import com.array.onlineshopspring.model.JwtResponse;
import com.array.onlineshopspring.service.serviceimpl.JwtServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping
public class JwtController {

    private final JwtServiceImpl jwtService;

    public JwtController(JwtServiceImpl jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
