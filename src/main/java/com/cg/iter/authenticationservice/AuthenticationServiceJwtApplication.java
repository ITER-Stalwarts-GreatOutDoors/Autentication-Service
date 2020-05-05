package com.cg.iter.authenticationservice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.repository.UserRepository;

@SpringBootApplication
public class AuthenticationServiceJwtApplication {

	@Autowired
	private UserRepository repository;
	
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "Sachiket", "Sachiket", "sachiket@gmail.com"),
				new User(102, "user1", "user1", "user1@gmail.com"),
				new User(103, "user2", "user2", "user2@gmail.com"),
				new User(104, "user3", "user3", "user3@gmail.com")
				
				).collect(Collectors.toList());
		repository.saveAll(users);
	
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceJwtApplication.class, args);
	}

}
