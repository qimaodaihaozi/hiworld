package com.xzh.mall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity //实体类
@Table(name = "category") //对应表名
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})

public class Category {//分类
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String name;

    @Transient//忽略字段 不让数据库存在products字段
    List<Product> products; //一个分类下有多个产品。
    @Transient //忽略字段 不让数据库存在productsByRow字段
    List<List<Product>> productsByRow;//一个分类又对应多个 List<Product> 在首页竖状导航的分类名称右边显示推荐产品列表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}
