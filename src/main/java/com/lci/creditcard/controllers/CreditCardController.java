package com.lci.creditcard.controllers;

import com.lci.creditcard.model.CreditCard;
import com.lci.creditcard.model.CreditScore;
import com.lci.creditcard.repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CreditCardController {
    @Autowired
    private CreditCardRepo creditCardRepo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/issueCard")
    public boolean issueCard(@RequestBody CreditCard card) {
        if(getScore(card.getSsn()) >= 700) {
            creditCardRepo.save(card);
            return true;
        }
        return false;
    }

    private int getScore(String ssn) {
        CreditScore score = restTemplate.getForObject("http://localhost:8080/creditscore/creditscores/" + ssn, CreditScore.class);
        return score.getScore();
    }
}
