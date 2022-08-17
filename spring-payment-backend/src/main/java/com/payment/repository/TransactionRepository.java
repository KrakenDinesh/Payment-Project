package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
}
