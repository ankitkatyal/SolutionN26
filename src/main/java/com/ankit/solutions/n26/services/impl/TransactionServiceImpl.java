package com.ankit.solutions.n26.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.ankit.solutions.n26.domain.TransactionStatistic.INIT;
import com.ankit.solutions.n26.dao.TransactionDao;
import com.ankit.solutions.n26.dao.impl.TransactionDaoImpl;
import com.ankit.solutions.n26.domain.Transaction;
import com.ankit.solutions.n26.domain.TransactionStatistic;
import com.ankit.solutions.n26.services.TransactionService;
import com.google.common.annotations.VisibleForTesting;

@Service
public class TransactionServiceImpl  implements TransactionService{
	  private final TransactionDao<TransactionStatistic> transactions;

	    @Autowired
	    public TransactionServiceImpl() {
	        this(TransactionDaoImpl.lastMinute(() -> INIT));
	    }

	    @VisibleForTesting
	    protected TransactionServiceImpl(TransactionDao<TransactionStatistic> transactions) {
	        this.transactions = transactions;
	    }

	    @Override
	    public void loadTransactions(Transaction transaction) {
	        transactions.update(transaction.getTimestamp(), statistic -> statistic.register(transaction.getAmount()));
	    }

	    @Override
	    public TransactionStatistic getTransactionStatistics() {
	        return transactions.reduce(TransactionStatistic::merge);
	    }

}
