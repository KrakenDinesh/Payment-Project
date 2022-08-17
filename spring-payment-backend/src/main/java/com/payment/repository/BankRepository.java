package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.domain.Banks;

public interface BankRepository extends JpaRepository<Banks, String> {

}
