package com.ankit.solutions.n26.services;

import com.ankit.solutions.n26.domain.Transaction;
import com.ankit.solutions.n26.domain.TransactionStatistic;

public interface TransactionService {
	void loadTransactions(Transaction transaction);

    TransactionStatistic getTransactionStatistics();
	}

