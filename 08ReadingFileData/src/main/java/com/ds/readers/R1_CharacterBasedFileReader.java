package com.ds.readers;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.ds.Product;
import com.ds.mapper.ProductFieldSetMapper;

public class R1_CharacterBasedFileReader {

	private static DelimitedLineTokenizer productLineTokenizer(){
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		String[] names = {"PRODUCT_ID", "NAME","DESCRIPTION","PRICE"};
		tokenizer.setNames(names);
		return tokenizer;
	}

	private static DefaultLineMapper<Product> productLineMapper(){
		DefaultLineMapper<Product> mapper = new DefaultLineMapper<Product>();
		mapper.setLineTokenizer(productLineTokenizer());
		mapper.setFieldSetMapper(new ProductFieldSetMapper());
		return mapper;
	}

	public static FlatFileItemReader<Product> getReader() {
		FlatFileItemReader<Product> reader = new FlatFileItemReader<Product>();
		reader.setResource(new ClassPathResource("/input/1-character-separated-product"));
		reader.setLinesToSkip(2);
		String[] comments = {"@"};
		reader.setComments(comments);
		reader.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
		reader.setLineMapper(productLineMapper());
		return reader;
	}


}
