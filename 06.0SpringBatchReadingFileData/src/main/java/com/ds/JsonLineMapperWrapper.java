package com.ds;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.JsonLineMapper;

public class JsonLineMapperWrapper implements LineMapper<Product> {
	private JsonLineMapper delegate;

	public Product mapLine(String line, int lineNumber) throws Exception {
		Map<String, Object> productAsMap = delegate.mapLine(line, lineNumber);
		Product product = new Product();
		product.setId((String) productAsMap.get("id"));
		product.setName((String) productAsMap.get("name"));
		product.setDescription((String) productAsMap.get("description"));
		product.setPrice(BigDecimal.valueOf(new Float((String) productAsMap.get("price"))));
		System.out.println(product);
		return product;
	}
}