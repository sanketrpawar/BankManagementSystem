package com.braindata.bankmanagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



@NamedQueries({ 
	@NamedQuery(name = "Showall", query = "from Bank"),
	@NamedQuery(name="Deposit Amount",query="FROM Account WHERE accNo = :accNo"),
	@NamedQuery(name="Withdraw",query="FROM Account WHERE accNo=:accNo"),
	@NamedQuery(name="Balance Check",query="FROM Account WHERE accNo=:accNo")
})
@Entity
public class Bank 
{
	@Id
	private int bank_code;
	private String bank_Address;
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Account> Accn= new HashSet<>();
	public int getBank_code() {
		return bank_code;
	}
	public void setBank_code(int bank_code) {
		this.bank_code = bank_code;
	}
	public String getBank_Address() {
		return bank_Address;
	}
	public void setBank_Address(String bank_Address) {
		this.bank_Address = bank_Address;
	}
	public Set<Account> getAccn() {
		return Accn;
	}
	public void setAccn(Set<Account> accn) {
		Accn = accn;
	}
	
	
	
//	

	
	
}
