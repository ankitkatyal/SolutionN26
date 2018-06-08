package com.ankit.solutions.n26.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.solutions.n26.domain.Transaction;
import com.ankit.solutions.n26.exceptions.InvalidTimestampException;
import com.ankit.solutions.n26.services.TransactionService;


@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void loadTransaction(@Valid @RequestBody Transaction transaction) {
    	try{
    	transactionService.loadTransactions(transaction);
    	}catch (InvalidTimestampException e){
    		System.out.println(e.getMessage());
    	}
    }
}
