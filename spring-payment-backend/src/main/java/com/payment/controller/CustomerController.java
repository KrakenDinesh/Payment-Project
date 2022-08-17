package com.payment.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.repository.CustomersRepository;
import com.payment.repository.TransactionRepository;
import com.payment.domain.Customers;
import com.payment.domain.Transaction;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private final CustomersRepository customerRepo;

	public CustomerController(CustomersRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@GetMapping
	public List<Customers> getCustomers() {
		return customerRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Customers getCustomer(@PathVariable String id) {
		return customerRepo.findById(id).orElseThrow(RuntimeException::new);
	}

	// update
	@PutMapping("{id}")
	public boolean updateCustomers(@PathVariable String id, @RequestBody Customers customer) {
		Customers currentCustomer = customerRepo.findById(id).orElseThrow(RuntimeException::new);
		currentCustomer.setClearbalance(customer.getClearbalance());
		customerRepo.save(currentCustomer);
		return true;
	}

	// delete
	@DeleteMapping("/{id}")
	public String deleteCustomers(@PathVariable String id) {
		customerRepo.deleteById(id);
		return "Deleted";
	}
//	@GetMapping("{name}")
//	public boolean getReceiver(@RequestBody String name) {
//		System.out.println(name.trim());
//		HashMap<String, Customers> hm = new HashMap<String, Customers>();
//		List<Customers> receivers = customerRepo.findAll();
//		for (int i = 0; i < receivers.size(); i++)
//			hm.put(receivers.get(i).getAccountholdername().trim(), receivers.get(i));
//		System.out.println(Arrays.toString(receivers.toArray()));
//		return hm.containsKey(name.trim());
//	}
}
