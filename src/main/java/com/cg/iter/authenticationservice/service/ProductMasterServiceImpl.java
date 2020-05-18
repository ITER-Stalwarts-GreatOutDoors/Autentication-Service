package com.cg.iter.authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.authenticationservice.entity.ProductDTO;

@Service
public class ProductMasterServiceImpl implements ProductMasterService{

	@Autowired
	RestTemplate restTemplate;
	
	private String productURL = "http://product-ms/product";
	
	@Override
	public String addProduct(ProductDTO product) {
		return restTemplate.postForObject(productURL+"/addProduct",product, String.class);
	}

	@Override
	public String deleteProduct(String productId) {
		
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("productId",productId);
		
		return restTemplate.postForObject(productURL+"/deleteProduct",parametersMap,String.class);
	}

}
