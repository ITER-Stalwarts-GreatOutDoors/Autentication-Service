package com.cg.iter.authenticationservice.service;

import java.util.List;

import com.cg.iter.authenticationservice.entity.User;

public interface AdminProductMasterService {

	
	/*
	 * Name: deleteProductMaster
	 * Description: Only admin can add a new product master. Method returns a boolean.
	 */
	boolean deleteProductMaster(int userId);

	
	/*
	 * Name: addProductMaster
	 * Description: Only admin can delete a product master. Method return a boolean.
	 */
	boolean addProductMaster(User user);

	
	
	/*
	 * Name: viewAllProductMasters
	 * Description: Only admin can view the list of product masters. Method returns a list.
	 */
	List<User> viewAllProductMasters();

}
