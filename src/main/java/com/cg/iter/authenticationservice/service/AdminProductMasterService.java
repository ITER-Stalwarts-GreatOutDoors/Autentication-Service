package com.cg.iter.authenticationservice.service;

import java.util.List;

import com.cg.iter.authenticationservice.entity.User;

public interface AdminProductMasterService {

	boolean deleteProductMaster(User user);

	boolean addProductMaster(User user);

	List<User> viewAllProductMasters();

}
