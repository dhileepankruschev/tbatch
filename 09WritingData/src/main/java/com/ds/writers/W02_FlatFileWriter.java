package com.ds.writers;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.core.io.FileSystemResource;

import com.ds.Product;

public class W02_FlatFileWriter {

	public static FlatFileItemWriter<Product> getWriter(){
		FlatFileItemWriter<Product> writer = new FlatFileItemWriter<Product>();
		writer.setResource(new FileSystemResource("output/product.txt"));
		writer.setLineAggregator(new PassThroughLineAggregator<Product>());
		return writer;
	}
}
