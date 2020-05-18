package com.cg.iter.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.service.AdminProductMasterService;
import com.cg.iter.authenticationservice.service.AdminRetailerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app/admin")
public class AdminController {

	
	@Autowired
	AdminProductMasterService productMasterService;
	
	AdminRetailerService retailerService;
	
	@PostMapping("/deleteProductMaster")
	@PreAuthorize("hasRole('ADMIN')")
	String deleteProductMaster(@RequestBody User user) {
		if(productMasterService.deleteProductMaster(user)) {
			return "Product master deleted successfully";
		}
		return "fail to delete Product master!!";
	}
	
	@PostMapping("/addProductMaster")
	@PreAuthorize("hasRole('ADMIN')")
	String addProductMaster(@RequestBody User user) {
		if(productMasterService.addProductMaster(user)) {
			return "Product master added successfully";
		}
		return "fail to add Product master!!";
	}
	
	@GetMapping("/viewAllProductMasters")
	@PreAuthorize("hasRole('ADMIN')")
	List<User> viewAllProductMasters() {
		return productMasterService.viewAllProductMasters();
		
	}
	
	@PostMapping("/deleteRetailer")
	@PreAuthorize("hasRole('ADMIN')")
	String deleteRetailer(@RequestBody User user) {
		if(retailerService.deleteRetailer(user)) {
			return "Retailer deleted successfully";
		}
		return "fail to delete Retailer!!";
	}
	
	@PostMapping("/addRetailer")
	@PreAuthorize("hasRole('ADMIN')")
	String addRetailer(@RequestBody User user) {
		if(retailerService.addProductMaster(user)) {
			return "Retailer added successfully";
		}
		return "fail to add Retailer!!";
	}
	
	@GetMapping("/viewAllRetailers")
	@PreAuthorize("hasRole('ADMIN')")
	List<User> viewAllRetailers() {
		return retailerService.viewAllRetailers();
		
	}
	
	
	
	
	
}
