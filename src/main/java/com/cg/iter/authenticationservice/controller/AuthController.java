package com.cg.iter.authenticationservice.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.iter.authenticationservice.entity.request.LoginRequest;
import com.cg.iter.authenticationservice.entity.request.SignupRequest;
import com.cg.iter.authenticationservice.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/app/auth")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return userService.authenticateUser(loginRequest);
	}
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		return userService.registerUser(signUpRequest);
	}
	
	
	@GetMapping("/welcome")
	String welcome() {
		return "WECOME";
	}
	
}
