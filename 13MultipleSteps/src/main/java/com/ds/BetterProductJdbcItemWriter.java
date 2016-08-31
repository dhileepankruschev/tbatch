package com.ds;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

public class BetterProductJdbcItemWriter implements ItemWriter<BetterProduct> {
	private static final String INSERT_PRODUCT = "insert into betterproduct (id,name,description,price,mfd) values(?,?,?,?,?)";
	private static final String UPDATE_PRODUCT = "update betterproduct set name=?, description=?, price=?, mfd=? where id=?";
	
	private JdbcTemplate jdbcTemplate;

	public BetterProductJdbcItemWriter(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public void write(List<? extends BetterProduct> items) throws Exception {
		for (BetterProduct item : items) {
			int updated = jdbcTemplate.update(UPDATE_PRODUCT, item.getName(), item.getDescription(), item.getPrice(), item.getId());
			if (updated == 0) {
				jdbcTemplate.update(INSERT_PRODUCT, item.getId(), item.getName(), item.getDescription(), item.getPrice());
			}
		}
	}
}