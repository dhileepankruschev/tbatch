package com.demo.batch;

public class Order {
	private String custId, orderNum, country;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Order [custId=" + custId + ", orderNum=" + orderNum
				+ ", country=" + country + "]";
	}
	
	
}
