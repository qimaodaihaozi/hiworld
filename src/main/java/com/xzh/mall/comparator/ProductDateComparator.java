package com.xzh.mall.comparator;
import com.xzh.mall.pojo.Product;
import java.util.Comparator;


public class ProductDateComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		return p2.getCreateDate().compareTo(p1.getCreateDate());
	}

}
