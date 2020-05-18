package com.cg.iter.authenticationservice.service;

import com.cg.iter.authenticationservice.entity.ProductDTO;

public interface ProductMasterService {

	String addProduct(ProductDTO product);

	String deleteProduct(String productId);
	
	

}
