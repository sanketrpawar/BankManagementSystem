package com.braindata.bankmanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account 
{
	@Id
	private int accNo;
	private String name;
	private Float Account_Amount;
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getAccount_Amount() {
		return Account_Amount;
	}
	public void setAccount_Amount(Float account_Amount) {
		Account_Amount = account_Amount;
	}
	
	
	
	
	
	
}
