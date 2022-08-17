package com.payment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@Column(name = "transaction_Id")
	private long transaction_Id;

	@Column(name = "sender_id")
	private long sender_id;

	@Column(name = "receiver_name")
	private String receiver_name;

	@Column(name = "receiver_Id")
	private String receiver_Id;

	@Column(name = "bic")
	private String bic;

	@Column(name = "amount")
	private double amount;

	@Column(name = "transfer")
	private double transfer;

	@Column(name = "clear_balance")
	private double clear_balance;

	@Column(name = "trans_date")
	private String trans_date;

	@Column(name = "message_real")
	private String message_real;

	@Column(name = "transfer_type")
	private String transfer_type;

	public long getTransaction_Id() {
		return transaction_Id;
	}

	public void setTransaction_Id(long transaction_Id) {
		this.transaction_Id = transaction_Id;
	}

	public long getSender_id() {
		return sender_id;
	}

	public void setSender_id(long sender_id) {
		this.sender_id = sender_id;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getReceiver_Id() {
		return receiver_Id;
	}

	public void setReceiver_Id(String receiver_Id) {
		this.receiver_Id = receiver_Id;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTransfer() {
		return transfer;
	}

	public void setTransfer(double transfer) {
		this.transfer = transfer;
	}

	public double getClear_balance() {
		return clear_balance;
	}

	public void setClear_balance(double clear_balance) {
		this.clear_balance = clear_balance;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public String getMessage_real() {
		return message_real;
	}

	public void setMessage_real(String message_real) {
		this.message_real = message_real;
	}

	public String getTransfer_type() {
		return transfer_type;
	}

	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}

}