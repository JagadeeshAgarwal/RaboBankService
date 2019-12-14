package com.rabobank.model;

import java.math.BigDecimal;

public class CustomerStatementRecord {

	String transReference;
	String accountNumber;
	BigDecimal startBalance;
	String mutation;
	String description;
	BigDecimal endBalance;
	public String getTransReference() {
		return transReference;
	}
	public void setTransReference(String transReference) {
		this.transReference = transReference;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getStartBalance() {
		return startBalance;
	}
	public void setStartBalance(BigDecimal startBalance) {
		this.startBalance = startBalance;
	}
	public String getMutation() {
		return mutation;
	}
	public void setMutation(String mutation) {
		this.mutation = mutation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getEndBalance() {
		return endBalance;
	}
	public void setEndBalance(BigDecimal endBalance) {
		this.endBalance = endBalance;
	}
	
	
}
