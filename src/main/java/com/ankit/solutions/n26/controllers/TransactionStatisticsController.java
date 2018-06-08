package com.ankit.solutions.n26.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.solutions.n26.domain.TransactionStatistic;
import com.ankit.solutions.n26.services.TransactionService;


@RestController
@RequestMapping("/api/statistics")
public class TransactionStatisticsController {

    private final TransactionService metricsService;

    @Autowired
    public TransactionStatisticsController(TransactionService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping(produces = "application/json")
    public TransactionStatistic getTransactionStatistics() {
        return metricsService.getTransactionStatistics();
    }
}