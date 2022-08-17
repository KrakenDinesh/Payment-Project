package com.payment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Customers;
import com.payment.domain.MessageCode;
import com.payment.repository.MessageCodeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/message")
public class MessageController {

	private static MessageCodeRepository msgCode;

	public MessageController(MessageCodeRepository msgCode) {
		super();
		this.msgCode = msgCode;
	}

	@GetMapping
	public List<MessageCode> getMessage() {
		return msgCode.findAll();
	}
	@GetMapping("{ele}")
	public static MessageCode getMessage(@PathVariable String ele) {
		return msgCode.findById(ele).orElseThrow(RuntimeException::new);
	}

//	@GetMapping("/{element}")
//	public ResponseEntity getMessage(@PathVariable String element) {
//		MessageCode message = msgCode.findById(element).orElseThrow(RuntimeException::new);
////		System.out.println(message.getInstruction());
//		return ResponseEntity.ok(message);
//	}

}
