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
public class AdminProductMasterServiceImpl implements AdminProductMasterService{

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean deleteProductMaster(User user) {
		userRepository.delete(user);
		return true;
	}

	@Override
	public boolean addProductMaster(User user) {
		Set<String> roles = new HashSet<>();
		roles.add(ERole.ROLE_USER.toString());
		roles.add(ERole.ROLE_PRODUCT_MASTER.toString());
		user.setId((int)userRepository.count());
		user.setRoles(roles);
		userRepository.save(user);
		return true;
	}

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
