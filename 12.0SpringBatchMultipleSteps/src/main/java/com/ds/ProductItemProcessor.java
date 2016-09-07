package com.ds;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

public class ProductItemProcessor implements ItemProcessor<Product, Product>{
	public Product process(final Product product) throws Exception {
		
		Thread.sleep(1000);

		
		final String id = product.getId().toUpperCase();
		final String name = product.getName().toUpperCase();
		final String description = product.getDescription().toLowerCase();
		final BigDecimal price = product.getPrice();
		final Product transformedProduct = new Product(id, name, description, price);

		  System.out.println("Converting (" + product + ") into (" + transformedProduct + ")");
		  return transformedProduct;
		 }
}
