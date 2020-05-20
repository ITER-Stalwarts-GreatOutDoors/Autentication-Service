package com.cg.iter.authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import com.cg.iter.authenticationservice.entity.ProductDTO;

@Service
public class ProductMasterServiceImpl implements ProductMasterService{

	@Autowired
	RestTemplate restTemplate;
	private String productURL = "http://product-ms/product";


	@HystrixCommand(fallbackMethod = "getFallbackAddProduct",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			})	
	@Override
	public String addProduct(ProductDTO product) {
		return restTemplate.postForObject(productURL+"/addProduct",product, String.class);
	}

	
	@HystrixCommand(fallbackMethod = "getFallbackDeleteProduct",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
			})
	@Override
	public String deleteProduct(String productId) {
		
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("productId",productId);
		
		return restTemplate.postForObject(productURL+"/deleteProduct",parametersMap,String.class);
	}
	
	String getFallbackAddProduct(ProductDTO product) {
		return "Add product service is not responding...";
	}
	String getFallbackDeleteProduct(ProductDTO product) {
		return "Delete product service is not responding...";
	}

}
