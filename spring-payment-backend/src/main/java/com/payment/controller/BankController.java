package com.payment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Banks;
import com.payment.repository.BankRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/banks")
public class BankController {
	public final BankRepository bankRepo;

	public BankController(BankRepository bankRepo) {
		super();
		this.bankRepo = bankRepo;
	}

	@GetMapping
	public List<Banks> getBanks() {
		return bankRepo.findAll();
	}

	@GetMapping("{id}")
	public Banks getBank(@PathVariable String id) {
		return bankRepo.findById(id).orElseThrow(RuntimeException::new);
	}

}
