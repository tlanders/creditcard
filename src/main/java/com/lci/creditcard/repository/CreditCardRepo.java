package com.lci.creditcard.repository;

import com.lci.creditcard.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepo extends JpaRepository<CreditCard, String> {
}
