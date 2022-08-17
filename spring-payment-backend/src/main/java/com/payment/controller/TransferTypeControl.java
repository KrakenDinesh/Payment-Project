package com.payment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.TransferType;
import com.payment.repository.TransferTypeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/transfertype")
public class TransferTypeControl {
	public final TransferTypeRepository transferTypeRepo;

	public TransferTypeControl(TransferTypeRepository transferTypeRepo) {
		super();
		this.transferTypeRepo = transferTypeRepo;
	}

	@GetMapping
	public List<TransferType> getCustomers() {
		return transferTypeRepo.findAll();
	}

}
