package com.cg.iter.authenticationservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.authenticationservice.entity.ERole;
import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.repository.UserRepository;


@Service
public class AdminRetailerServiceImpl implements AdminRetailerService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthService authService;
	
	
	/*
	 * Name: deleteRetailer
	 * Description: Only admin can add a new retailer. Method returns a boolean.
	 */
	@Override
	public boolean deleteRetailer(int userId) {
		userRepository.deleteById(userId);
		return true;
	}

	
	
	/*
	 * Name: deleteRetailer
	 * Description: Only admin can add a new retailer eith role as user and retailer. Method returns a boolean.
	 */
	@Override
	public boolean addRetailer(User user) {
		Set<String> roles = new HashSet<>();
		roles.add(ERole.ROLE_USER.toString());
		roles.add(ERole.ROLE_RETAILER.toString());
		user.setRoles(roles);
		authService.addUser(user);
		return true;
	}

	
	
	
	/*
	 * Name: viewAllRetailers
	 * Description: Only admin can view the list of retaliers and return a boolean. Method list.
	 */
	@Override
	public List<User> viewAllRetailers() {
		List<User> resultList = new ArrayList<>();
		List<User> allUsers = userRepository.findAll();
		
		Iterator<User> itr = allUsers.iterator();
		
		int index = 0;
		
		while (itr.hasNext()) {
			
			if(allUsers.get(index).getRoles().contains(ERole.ROLE_RETAILER.toString())) {
				resultList.add(allUsers.get(index));
			}
			index++;
			itr.next();
		}
		return resultList;
	}

}
