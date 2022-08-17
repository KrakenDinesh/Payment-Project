package com.payment.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {
	@Id
	private String currencycode;
	private String currencyname;
	private double conversionrate;

	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Currency(String currencycode, String currencyname, double conversionrate) {
		super();
		this.currencycode = currencycode;
		this.currencyname = currencyname;
		this.conversionrate = conversionrate;
	}

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getCurrencyname() {
		return currencyname;
	}

	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}

	public double getConversionrate() {
		return conversionrate;
	}

	public void setConversionrate(double conversionrate) {
		this.conversionrate = conversionrate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conversionrate, currencycode, currencyname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		return Double.doubleToLongBits(conversionrate) == Double.doubleToLongBits(other.conversionrate)
				&& Objects.equals(currencycode, other.currencycode) && Objects.equals(currencyname, other.currencyname);
	}

	@Override
	public String toString() {
		return "Currency [currencycode=" + currencycode + ", currencyname=" + currencyname + ", conversionrate="
				+ conversionrate + "]";
	}

}
