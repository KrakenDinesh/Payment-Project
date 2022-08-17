package com.payment.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Customers;
import com.payment.repository.CustomersRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/receiver")
public class ReceiverController {
	private final CustomersRepository customerRepo=null;
	@GetMapping("{name}")
	public boolean getCustomer(@PathVariable String name) {
		HashMap<String, Customers> hm = new HashMap<String, Customers>();
		List<Customers> receivers = customerRepo.findAll();
		for (int i = 0; i < receivers.size(); i++)
			hm.put(receivers.get(i).getAccountholdername(), receivers.get(i));
		System.out.println(Arrays.toString(receivers.toArray()));
		return hm.containsKey(name);
	}

}
