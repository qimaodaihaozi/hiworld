package com.xzh.mall.dao;

import com.xzh.mall.pojo.Product;
import com.xzh.mall.pojo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer>{
	public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
	
}
