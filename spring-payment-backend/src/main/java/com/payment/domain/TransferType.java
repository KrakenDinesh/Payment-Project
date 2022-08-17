package com.payment.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transfertype")
public class TransferType {
	@Id
	private String transfercode;
	private String transferdescription;

	public TransferType(String transfercode, String transferdescription) {
		super();
		this.transfercode = transfercode;
		this.transferdescription = transferdescription;
	}

	public TransferType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTransferTypecode() {
		return transfercode;
	}

	public void setTransferTypecode(String transfercode) {
		this.transfercode = transfercode;
	}

	public String getTransferTypedescription() {
		return transferdescription;
	}

	public void setTransferTypedescription(String transferdescription) {
		this.transferdescription = transferdescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(transfercode, transferdescription);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransferType other = (TransferType) obj;
		return Objects.equals(transfercode, other.transfercode)
				&& Objects.equals(transferdescription, other.transferdescription);
	}

	@Override
	public String toString() {
		return "TransferType [transfercode=" + transfercode + ", transferdescription=" + transferdescription + "]";
	}

}
