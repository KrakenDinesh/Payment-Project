package com.payment.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_code")
public class MessageCode {
	@Id
	private String messagecode;
	private String instruction;

	public MessageCode(String messagecode, String instruction) {
		super();
		this.messagecode = messagecode;
		this.instruction = instruction;
	}

	public MessageCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(instruction, messagecode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageCode other = (MessageCode) obj;
		return Objects.equals(instruction, other.instruction) && Objects.equals(messagecode, other.messagecode);
	}

	@Override
	public String toString() {
		return "Message_code [messagecode=" + messagecode + ", instruction=" + instruction + "]";
	}

}
