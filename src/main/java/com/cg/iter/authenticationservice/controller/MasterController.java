package com.cg.iter.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.authenticationservice.entity.ProductDTO;
import com.cg.iter.authenticationservice.service.ProductMasterService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app/master")
public class MasterController {
	
	@Autowired
	ProductMasterService productMasterService;
	
	@PostMapping("/addProduct")
	@PreAuthorize("hasRole('PRODUCT_MASTER')")
	String addProduct(@RequestBody ProductDTO product) {
		return productMasterService.addProduct(product);
	}
	
	@DeleteMapping("/deleteProduct")
	@PreAuthorize("hasRole('PRODUCT_MASTER')")
	String deleteProduct(@RequestParam String productId) {
		return productMasterService.deleteProduct(productId);
	}
	

	

}
