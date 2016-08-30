package com.ds.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.ds.Product;

public class ProductWriter implements ItemWriter<Product> {

	public void write(List<? extends Product> products) throws Exception {
		System.out.println(products);
	}

}
