package com.payment.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Banks;
import com.payment.domain.Customers;
import com.payment.domain.MessageCode;
import com.payment.domain.Transaction;
import com.payment.repository.BankRepository;
import com.payment.repository.CustomersRepository;
import com.payment.repository.MessageCodeRepository;
import com.payment.repository.TransactionRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private final TransactionRepository transactionRepo;
//	private final CustomersRepository customerRepo;
//	private final MessageCodeRepository messageRepo;
//	private final BankRepository bankRepo;
//
//	public TransactionController(TransactionRepository transactionRepo, CustomersRepository customerRepo,
//			MessageCodeRepository messageRepo, BankRepository bankRepo) {
//		super();
//		this.transactionRepo = transactionRepo;
//		this.customerRepo = customerRepo;
//		this.messageRepo = messageRepo;
//		this.bankRepo = bankRepo;
//	}

	@GetMapping
	public List<Transaction> getTranasactions() {
		return transactionRepo.findAll();
	}

	public TransactionController(TransactionRepository transactionRepo) {
		super();
		this.transactionRepo = transactionRepo;
	}

	@PostMapping
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return transactionRepo.save(transaction);
	}
	@GetMapping("{id}")
	public Transaction getBank(@PathVariable long id) {
		return transactionRepo.findById(id).orElseThrow(RuntimeException::new);
	}

//	private void debit(Customers customer, double amount) {
//		double balance = customer.getClearbalance();
//		if (customer.isOverdraftflag() || balance >= amount) {
//			balance -= amount;
//			customer.setClearbalance(balance);
//		}
//	}
//
//	private void credit(Customers customer, double amount) {
//		double balance = customer.getClearbalance();
//		balance += amount;
//		customer.setClearbalance(balance);
//	}

//	@PutMapping("/{id1}-&&-{id2}/{amount}/{msgcode}")
//	public ResponseEntity transaction(@PathVariable String id1, @PathVariable String id2, @PathVariable Double amount,@PathVariable String msgcode) {
//		Customers sender = customerRepo.findById(id1).orElseThrow(RuntimeException::new);
//		Customers receiver;
//		MessageCode msg = messageRepo.findById(msgcode).orElseThrow(RuntimeException::new);
//		if (customerRepo.existsById(id2)) {
//			receiver = customerRepo.findById(id2).orElseThrow(RuntimeException::new);
//			debit(sender, amount);
//			credit(receiver, amount);
//			customerRepo.save(sender);
//			customerRepo.save(receiver);
//		} else {
//			debit(sender, amount);
//			receiver = new Customers(id2,"", 0, id2, id1, id2, false);
//			customerRepo.save(sender);
//		}
//		return saveTransaction(sender,receiver,MessageController.getMessage(msgcode));
//	}

//	private ResponseEntity saveTransaction(Customers sender, Customers receiver) {
//		Transaction currentTransaction = new Transaction();
//		currentTransaction.setCustomer(sender);
//		currentTransaction.setReceiverAccountHolderName(receiver.getAccountholdername());
//		currentTransaction.setReceiverAccountHolderNumber(receiver.getCustomerid());
//		currentTransaction.setTrasferDate(new Date(System.currentTimeMillis()));
//		transactionRepo.save(currentTransaction);
//		return ResponseEntity.ok(currentTransaction);
//	}
//
//	private ResponseEntity saveTransaction(Customers sender, Customers receiver, MessageCode msg) {
//		Transaction currentTransaction = new Transaction();
//		currentTransaction.setCustomer(sender);
//		currentTransaction.setMessagecode(msg);
//		currentTransaction.setReceiverAccountHolderName(receiver.getAccountholdername());
//		currentTransaction.setReceiverAccountHolderNumber(receiver.getCustomerid());
//		currentTransaction.setTrasferDate(new Date(System.currentTimeMillis()));
//		transactionRepo.save(currentTransaction);
//		return ResponseEntity.ok(currentTransaction);
//	}

//	private boolean checkBic(Customers receiver, String bic) {
//		boolean check = false;
//		Banks bank = bankRepo.findById(bic).orElseThrow(RuntimeException::new);
//		bankRepo.findById(bic).orElse(bank);
//		return check;
//	}

}
