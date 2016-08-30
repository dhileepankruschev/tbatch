package com.ds.service;

import java.util.List;

import com.ds.Product;


public class ProductServiceAdapter {
	private ProductService productService;
	private List<Product> products;
	
	private int count = 0;

	public ProductServiceAdapter(ProductService productService){
		this.productService = productService;
		this.products = this.productService.getProducts();
	}


	public Product nextProduct() {
		if (count<products.size()) {
			return products.get(count++);
		} else {
			return null;
		}
	}

}