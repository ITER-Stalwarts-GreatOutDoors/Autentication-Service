package com.cg.iter.authenticationservice.service;

import com.cg.iter.authenticationservice.entity.ProductDTO;

public interface ProductMasterService {

	
	/*
	 * Name: addProduct
	 * Description: Only product master can add a new product and return status.
	 */
	String addProduct(ProductDTO product);

	
	
	/*
	 * Name: deleteProduct
	 * Description: Only product master can delete a product by product Id and return status.
	 */
	String deleteProduct(String productId);
	
	

}
