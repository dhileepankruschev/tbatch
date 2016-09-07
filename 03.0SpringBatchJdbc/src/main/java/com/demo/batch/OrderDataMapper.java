package com.demo.batch;
 
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
 
public class OrderDataMapper implements FieldSetMapper<Order> {
 
public Order mapFieldSet(FieldSet fieldSet) throws BindException {
 
	System.out.println("Reading n mapping");
Order order = new Order();
order.setCustId(fieldSet.readString(0));
order.setOrderNum(fieldSet.readString(1));
order.setCountry(fieldSet.readString(2));
return order;
 
}
 
}