package com.cg.iter.authenticationservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.iter.authenticationservice.entity.ERole;
import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.repository.UserRepository;
import com.cg.iter.authenticationservice.util.Validator;



@Service
public class AdminProductMasterServiceImpl implements AdminProductMasterService{

	@Autowired
	Validator validator;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthService authService;
	
	
	
	/*
	 * Name: deleteProductMaster
	 * Description: Only admin can add a new product master. Method returns a boolean.
	 */
	@Override
	public boolean deleteProductMaster(int userId) {
		userRepository.deleteById(userId);;
		return true;
	}

	
	
	/*
	 * Name: addProductMaster
	 * Description: Only admin can delete a product master. Method return a boolean.
	 */
	@Override
	public boolean addProductMaster(User user) {
		validator.checkPassword(user.getPassword());
		validator.checkPhoneNumber(user.getPhoneno());
		Set<String> roles = new HashSet<>();
		roles.add(ERole.ROLE_USER.toString());
		roles.add(ERole.ROLE_PRODUCT_MASTER.toString());
		user.setRoles(roles);
		authService.addUser(user);
		return true;
	}

	
	
	
	/*
	 * Name: viewAllProductMasters
	 * Description: Only admin can view the list of product masters. Method returns a list.
	 */
	@Override
	public List<User> viewAllProductMasters() {
		List<User> resultList = new ArrayList<>();
		List<User> allUsers = userRepository.findAll();
		
		Iterator<User> itr = allUsers.iterator();
		
		int index = 0;
		
		while (itr.hasNext()) {
			
			if(allUsers.get(index).getRoles().contains(ERole.ROLE_PRODUCT_MASTER.toString())) {
				resultList.add(allUsers.get(index));
			}
			index++;
			itr.next();
		}
		return resultList;
	}

}
