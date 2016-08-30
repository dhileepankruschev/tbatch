package com.ds.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ds.Product;

public class ProductItemWriter implements ItemWriter<Product> {

	private static final String INSERT_PRODUCT = "insert into product ( id, NAME, DESCRIPTION, PRICE ) values(?,?,?,?)";
	private JdbcTemplate jdbcTemplate;

	public void write(List<? extends Product> products) throws Exception {

		for (Product product : products) {

			jdbcTemplate.update(INSERT_PRODUCT, product.getId(),
					product.getName(), product.getDescription(),
					product.getPrice());
		}
		System.out.println("All the products are inserted into database");
	}

	public ProductItemWriter(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

}
/*
 * public class OrderItemWriter implements ItemWriter<Order> {
 * 
 * private static final String INSERT_ORDER =
 * "insert into batch.order ( ordernum, custid, country ) values(?,?,?)";
 * private JdbcTemplate jdbcTemplate;
 * 
 * @Override public void write(List<? extends Order> orders) throws Exception {
 * 
 * for (Order order : orders) {
 * 
 * jdbcTemplate.update(INSERT_ORDER, order.getOrderNum(), order.getCustId(),
 * order.getCountry()); }
 * 
 * }
 * 
 * public OrderItemWriter(DataSource ds) { this.jdbcTemplate = new
 * JdbcTemplate(ds); }
 */