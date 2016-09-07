package com.demo.record;

public class Record {

	private int id;
	private String debitAc;
	private String creditAc;
	private double amount;
	
	public Record(int id, String debitAc, String creditAc, double amount) {
		this.id = id;
		this.debitAc = debitAc;
		this.creditAc = creditAc;
		this.amount = amount;
	}
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getDebitAc() {
		return debitAc;
	}
	public void setDebitAc(String debitAc) {
		this.debitAc = debitAc;
	}
	public String getCreditAc() {
		return creditAc;
	}
	public void setCreditAc(String creditAc) {
		this.creditAc = creditAc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Record [id=" +id+", debitAc=" + debitAc + ", creditAc=" + creditAc
				+ ", amount=" + amount + "]";
	}
	
	
}
