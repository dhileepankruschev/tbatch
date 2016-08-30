package com.ds.readers;

import org.springframework.batch.item.adapter.ItemReaderAdapter;

import com.ds.Product;
import com.ds.service.ProductService;
import com.ds.service.ProductServiceAdapter;

public class R4_ServiceReader {
	public static ItemReaderAdapter<Product> getReader(){
		ItemReaderAdapter<Product> adapter = new ItemReaderAdapter<Product>();
		ProductServiceAdapter productServiceAdapter = new ProductServiceAdapter(new ProductService());
		adapter.setTargetMethod("nextProduct");
		adapter.setTargetObject(productServiceAdapter);
		return adapter;
	}

}
