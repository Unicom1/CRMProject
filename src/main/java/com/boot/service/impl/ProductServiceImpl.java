package com.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.domain.Product;
import com.boot.dao.mapper.ProductMapper;
import com.boot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.insertProduct(product);
	}

	@Override
	public Product selectProductById(int id) {
		// TODO Auto-generated method stub
		return productMapper.selectProductById(id);
	}
	
}
