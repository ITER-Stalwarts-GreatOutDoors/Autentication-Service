package com.cg.iter.authenticationservice.service;

import java.util.List;

import com.cg.iter.authenticationservice.entity.User;

public interface AdminRetailerService {

	/*
	 * Name: deleteRetailer
	 * Description: Only admin can add a new retailer. Method returns a boolean.
	 */
	boolean deleteRetailer(int uderId);

	
	
	/*
	 * Name: addRetailer
	 * Description: Only admin can delete a retailer. Method return a boolean.
	 */
	boolean addRetailer(User user);

	
	
	/*
	 * Name: viewAllRetailers
	 * Description: Only admin can view the list of retaliers and return a boolean. Method list.
	 */
	List<User> viewAllRetailers();



}
