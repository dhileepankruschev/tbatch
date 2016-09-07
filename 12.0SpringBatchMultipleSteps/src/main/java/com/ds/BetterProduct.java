package com.ds;

import java.math.BigDecimal;

public class BetterProduct extends Product{
	private String manufacturedDate;
	
	public BetterProduct(String manufacturedDate, String id, String name, String description, BigDecimal price) {
		super(id, name, description, price);
		this.manufacturedDate = manufacturedDate;
	}

	public String getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(String manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	@Override
	public String toString() {
		return "BetterProduct [manufacturedDate=" + manufacturedDate + ", d="
				+ getId() + ", name=" + getName() + ", description="
				+ getDescription() + ", price=" + getPrice() + "]";
	}
	
}
