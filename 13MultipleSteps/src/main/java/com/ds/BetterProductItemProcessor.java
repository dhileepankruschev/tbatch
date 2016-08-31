package com.ds;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;

public class BetterProductItemProcessor implements ItemProcessor<Product, BetterProduct>{
	public BetterProduct process(final Product product) throws Exception {
		
		Thread.sleep(1000);
		
		final String id = product.getId().toUpperCase();
		final String name = product.getName().toUpperCase();
		final String description = product.getDescription().toLowerCase();
		final BigDecimal price = product.getPrice();
		final Product transformedProduct = new Product(id, name, description, price);
		final String manufecturedDate = this.formatDate();
		final BetterProduct betterProduct = new BetterProduct(manufecturedDate, id, name, description, price);

		  System.out.println("Converting (" + product + ") into (" + betterProduct + ")");
		  return betterProduct;
		 }
	
	private String formatDate(){
		 DateFormat formatter = DateFormat.getInstance(); // Date and time
	      String dateStr = formatter.format(new Date());
	      return dateStr;
	}
}
