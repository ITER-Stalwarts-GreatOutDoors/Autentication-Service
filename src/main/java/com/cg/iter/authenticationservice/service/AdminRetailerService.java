package com.cg.iter.authenticationservice.service;

import java.util.List;

import com.cg.iter.authenticationservice.entity.User;

public interface AdminRetailerService {

	boolean deleteRetailer(User user);

	boolean addProductMaster(User user);

	List<User> viewAllRetailers();



}
