package com.cg.iter.authenticationservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app/route")
public class RouteController {

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PRODUCT_MASTER')")
	public String userAccess() {
		return "user";
	}

	@GetMapping("/master")
	@PreAuthorize("hasRole('PRODUCT_MASTER')")
	public String moderatorAccess() {
		return "master.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "admin";
	}
	
	
	@GetMapping("/retailer")
	@PreAuthorize("hasRole('RETAILER')")
	public String retailerAccess() {
		return "retailer";
	}
}
