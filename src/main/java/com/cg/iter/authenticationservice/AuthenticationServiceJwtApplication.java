package com.cg.iter.authenticationservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.iter.authenticationservice.entity.ERole;
import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.repository.UserRepository;

@SpringBootApplication
public class AuthenticationServiceJwtApplication {

	@Autowired
	private UserRepository repository;
	
//	@PostConstruct
//	public void initUsers() {
//		
//		
//		
//		Set<String> role_set = new HashSet<>();
//		
//		role_set.add(ERole.USER.toString());
//		role_set.add(ERole.PRODUCT_MASTER.toString());
//		
//		List<User> users = Stream.of(
//				new User(111,"Sachiket", "Sachiket", "sachiket@gmail.com","9937534568",role_set)
//				).collect(Collectors.toList());
//		repository.saveAll(users);
//	
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceJwtApplication.class, args);
	}

}
