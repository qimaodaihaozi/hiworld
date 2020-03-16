package com.xzh.mall.dao;

import com.xzh.mall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer>{

}
//CategoryDAO 类集成了 JpaRepository，提供了CRUD和分页 的各种常见功能
