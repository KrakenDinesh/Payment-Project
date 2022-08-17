package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.payment.domain.*;

public interface CustomersRepository extends JpaRepository<Customers, String> {

}
