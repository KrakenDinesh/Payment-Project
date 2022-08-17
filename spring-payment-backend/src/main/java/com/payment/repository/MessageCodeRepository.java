package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.payment.domain.MessageCode;

public interface MessageCodeRepository extends JpaRepository<MessageCode, String> {
}
