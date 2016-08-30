package com.ds.readers;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.core.io.FileSystemResource;

import com.ds.Product;
import com.ds.mapper.ProductFieldSetMapper;

public class R2_FixedLengthReader {

	public static FlatFileItemReader<Product> getReader(){
		FlatFileItemReader<Product> reader = new FlatFileItemReader<Product>();
		reader.setResource(new FileSystemResource("input/2-fixed-length-product"));
		reader.setLinesToSkip(2);
		reader.setComments(new String[]{"@"});
		reader.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
		reader.setLineMapper(productLineMapper());
		return reader;
	}
	
	private static FixedLengthTokenizer productLineTokenizer(){
		FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
		tokenizer.setColumns(new Range[]{new Range(1,5), new Range(7, 29), new Range(30, 54), new Range(55, 60)});
		tokenizer.setNames(new String[]{"PRODUCT_ID", "NAME", "DESCRIPTION", "PRICE"});
		return tokenizer;
	}
	
	private static DefaultLineMapper<Product> productLineMapper(){
		DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<Product>();
		lineMapper.setLineTokenizer(productLineTokenizer());
		lineMapper.setFieldSetMapper(new ProductFieldSetMapper());
		return lineMapper;
	}
}
