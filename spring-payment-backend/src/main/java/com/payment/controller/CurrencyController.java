package com.payment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Currency;
import com.payment.domain.Customers;
import com.payment.repository.CurrencyRepository;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	public final CurrencyRepository currencyRepo;

	public CurrencyController(CurrencyRepository currencyRepo) {
		super();
		this.currencyRepo = currencyRepo;
	}
	@GetMapping
	public List<Currency> getCustomers() {
		return currencyRepo.findAll();
	}

}
