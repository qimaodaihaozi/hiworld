package com.xzh.mall.dao;

import com.xzh.mall.pojo.Order;
import com.xzh.mall.pojo.OrderItem;
import com.xzh.mall.pojo.Product;
import com.xzh.mall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer>{
	List<OrderItem> findByOrderOrderByIdDesc(Order order);
	List<OrderItem> findByProduct(Product product);
	List<OrderItem> findByUserAndOrderIsNull(User user);
}
