package com.boot.service;

import com.boot.dao.domain.Product;

public interface ProductService {

	public int insertProduct(Product product); 
	
	public Product selectProductById(int id);
}
