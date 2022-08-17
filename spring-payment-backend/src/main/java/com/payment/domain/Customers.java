package com.payment.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {
	@Id
	private String customerid;
	private String accountholdername;
	private double clearbalance;
	private String customeraddress, customercity, customertype;
	private boolean overdraftflag;

	public Customers() {
		super();
	}

	public Customers(String customerid, String accountholdername, double clearbalance, String customeraddress,
			String customercity, String customertype, boolean overdraftflag) {
		super();
		this.customerid = customerid;
		this.accountholdername = accountholdername;
		this.clearbalance = clearbalance;
		this.customeraddress = customeraddress;
		this.customercity = customercity;
		this.customertype = customertype;
		this.overdraftflag = overdraftflag;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getAccountholdername() {
		return accountholdername;
	}

	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	public double getClearbalance() {
		return clearbalance;
	}

	public void setClearbalance(double clearbalance) {
		this.clearbalance = clearbalance;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomercity() {
		return customercity;
	}

	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}

	public String getCustomertype() {
		return customertype;
	}

	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}

	public boolean isOverdraftflag() {
		return overdraftflag;
	}

	public void setOverdraftflag(boolean overdraftflag) {
		this.overdraftflag = overdraftflag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountholdername, clearbalance, customeraddress, customercity, customerid, customertype,
				overdraftflag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return Objects.equals(accountholdername, other.accountholdername)
				&& Double.doubleToLongBits(clearbalance) == Double.doubleToLongBits(other.clearbalance)
				&& Objects.equals(customeraddress, other.customeraddress)
				&& Objects.equals(customercity, other.customercity) && Objects.equals(customerid, other.customerid)
				&& Objects.equals(customertype, other.customertype) && overdraftflag == other.overdraftflag;
	}

	@Override
	public String toString() {
		return "Customers [customerid=" + customerid + ", accountholdername=" + accountholdername + ", clearbalance="
				+ clearbalance + ", customeraddress=" + customeraddress + ", customercity=" + customercity
				+ ", customertype=" + customertype + ", overdraftflag=" + overdraftflag + "]";
	}
	

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customertransactionid")
//	private List<Transaction> transaction = new ArrayList<Transaction>();

}