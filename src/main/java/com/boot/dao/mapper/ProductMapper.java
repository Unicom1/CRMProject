package com.boot.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dao.domain.Product;

@Mapper
public interface ProductMapper {

	/**
	 * 新增产品
	 * @param product
	 * @return
	 */
	public int insertProduct(Product product); 
	
	/**
	 * 根据ID获取产品信息
	 * @param id
	 * @return
	 */
	public Product selectProductById(int id);
}
