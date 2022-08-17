package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.domain.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {

}
