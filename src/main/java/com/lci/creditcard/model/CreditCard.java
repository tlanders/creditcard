package com.lci.creditcard.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class CreditCard {
    @Id
    private String ssn;
    private String firstName;
    private String lastName;
    private String cardNumber;
    private Date expiryDate;
    private int secCode;
}
