package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.domain.TransferType;

public interface TransferTypeRepository extends JpaRepository<TransferType, String>{

}
