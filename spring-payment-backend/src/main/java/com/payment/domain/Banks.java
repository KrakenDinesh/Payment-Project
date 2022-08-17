package com.payment.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banks")
public class Banks {
	@Id
	private String bic;
	private String bankname;

	public Banks(String bic, String bankname) {
		super();
		this.bic = bic;
		this.bankname = bankname;
	}

	public Banks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankname, bic);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banks other = (Banks) obj;
		return Objects.equals(bankname, other.bankname) && Objects.equals(bic, other.bic);
	}

	@Override
	public String toString() {
		return "Banks [bic=" + bic + ", bankname=" + bankname + "]";
	}

}
