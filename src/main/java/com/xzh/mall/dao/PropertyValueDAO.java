package com.xzh.mall.dao;


import com.xzh.mall.pojo.Product;
import com.xzh.mall.pojo.Property;
import com.xzh.mall.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer>{

	List<PropertyValue> findByProductOrderByIdDesc(Product product);
	PropertyValue getByPropertyAndProduct(Property property, Product product);

	
	
	
}
