package com.xzh.mall.dao;
import java.util.List;
import com.xzh.mall.pojo.Order;
import com.xzh.mall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order,Integer>{
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);

}
