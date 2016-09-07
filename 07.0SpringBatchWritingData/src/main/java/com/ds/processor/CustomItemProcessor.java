package com.ds.processor;

import org.springframework.batch.item.ItemProcessor;

import com.ds.Product;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {

	public Product process(Product item) throws Exception {
		
		System.out.println("Processing..." + item);
		return item;
	}

}