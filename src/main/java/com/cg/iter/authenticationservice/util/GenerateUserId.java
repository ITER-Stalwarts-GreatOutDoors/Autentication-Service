package com.cg.iter.authenticationservice.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.iter.authenticationservice.service.UserService;



@Component
public class GenerateUserId {

	@Autowired
	UserService service;
	private static Random rand = new Random();
	
	
	public int generateUserId(String phoneno) {
		int userId = 7;
		int selected = rand.nextInt(1000);
		userId*=selected;
		userId+=Integer.parseInt(phoneno.substring(5, 7));
		return userId;
	}
	
	
}
