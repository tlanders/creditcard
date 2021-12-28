package com.lci.creditcard.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class CreditScore {
    @Id
    private String ssn;
    private String firstName;
    private String lastName;
    private int score;
}
