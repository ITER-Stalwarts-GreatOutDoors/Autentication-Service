package com.cg.iter.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/app/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/editUser")
	@PreAuthorize("hasRole('USER') or hasRole('PRODUCT_MASTER') or hasRole('ADMIN') or hasRole('RETAILER')")
	String editUser(@RequestBody User user) {
		if(userService.editUser(user)) {
			return "User updated successfully";
		}
		return "fail to edit user!!";
	}
	
//	@PostMapping("/deleteUser")
//	@PreAuthorize("hasRole('USER') or hasRole('PRODUCT_MASTER') or hasRole('ADMIN') or hasRole('RETAILER')")
//	String deleteProductMaster(@RequestBody User user) {
//		if(userService.deleteUser(user)) {
//			return "User deleted successfully";
//		}
//		return "fail to delete user!!";
//	}
//	
	
	
	

}
