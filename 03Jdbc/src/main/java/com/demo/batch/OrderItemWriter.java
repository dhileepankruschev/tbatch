package com.demo.batch;
 
import java.util.List;
 

import javax.sql.DataSource;
 

import org.springframework.jdbc.core.JdbcTemplate;
 
import org.springframework.batch.item.ItemWriter;
 
public class OrderItemWriter implements ItemWriter<Order> {
 
private static final String INSERT_ORDER = "insert into order_table ( ordernum, custid, country ) values(?,?,?)";
private JdbcTemplate jdbcTemplate;
 
public void write(List<? extends Order> orders) throws Exception {
 
for (Order order : orders) {
 
int count = jdbcTemplate.update(INSERT_ORDER, order.getOrderNum(),
order.getCustId(), order.getCountry());
System.out.println("Count is" + count );
}
 
}
 
public OrderItemWriter(DataSource ds) {
this.jdbcTemplate = new JdbcTemplate(ds);
}
 
}