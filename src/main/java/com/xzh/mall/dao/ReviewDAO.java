package com.xzh.mall.dao;

import com.xzh.mall.pojo.Product;
import com.xzh.mall.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review,Integer>{

	List<Review> findByProductOrderByIdDesc(Product product);
	int countByProduct(Product product);

}
