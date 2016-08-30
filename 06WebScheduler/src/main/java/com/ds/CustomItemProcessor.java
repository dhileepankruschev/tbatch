package com.ds;

import org.springframework.batch.item.ItemProcessor;


public class CustomItemProcessor implements ItemProcessor<Product, Product> {

	public Product process(Product item) throws Exception {
		System.out.println("Processing..." + item);
		return item;

	}


}