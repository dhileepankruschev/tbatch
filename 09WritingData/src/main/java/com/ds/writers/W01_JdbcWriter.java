package com.ds.writers;

import javax.sql.DataSource;

import com.ds.jdbc.ProductItemWriter;

public class W01_JdbcWriter {
	
	public static ProductItemWriter getWriter(DataSource ds){
		return new ProductItemWriter(ds);
	}
}
