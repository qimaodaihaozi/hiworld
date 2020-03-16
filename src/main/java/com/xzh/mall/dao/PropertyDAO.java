package com.xzh.mall.dao;

import com.xzh.mall.pojo.Category;
import com.xzh.mall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyDAO extends JpaRepository<Property,Integer>{
	Page<Property> findByCategory(Category category, Pageable pageable);//这个是个接口没有实现类 进行条件查询方法名上面做文章。findByCategory，基于Category进行查询，第二个参数传一个 Pageable ， 就支持分页
	List<Property> findByCategory(Category category);

}
