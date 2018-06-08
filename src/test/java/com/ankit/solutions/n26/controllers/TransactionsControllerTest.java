package com.ankit.solutions.n26.controllers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ankit.solutions.n26.domain.ImmutableTransaction;
import com.ankit.solutions.n26.domain.Transaction;
import com.ankit.solutions.n26.exceptions.InvalidTimestampException;
import com.ankit.solutions.n26.services.TransactionService;
import com.ankit.solutions.n26.validations.InsideTimeValidator;



@RunWith(SpringRunner.class)
@WebMvcTest(TransactionsController.class)
public class TransactionsControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TransactionService transactionService;

	@Before
	public void setUp() throws Exception {
		InsideTimeValidator.currentTime = () -> 1528440523195L;
	}

	@Test
	public void shouldAcceptValidRequest() throws Exception {
		mvc.perform(post("/api/transactions").contentType("application/json")
				.content("{\"amount\": 12.3,\"timestamp\": 1528440523195}")).andExpect(status().isCreated())
				.andExpect(content().bytes(new byte[0]));

		verify(transactionService).register(ImmutableTransaction.of(12.3, 1528440523195L));
	}

	@Test
	public void shouldValidateRequest() throws Exception {
		mvc.perform(post("/api/transactions").contentType("application/json").content("{\"timestamp\": 0}"))
				.andExpect(status().isBadRequest()).andExpect(content().bytes(new byte[0]));

		verifyZeroInteractions(transactionService);
	}

	@Test
	public void shouldHandleInvalidTimestampException() throws Exception {
		doThrow(new InvalidTimestampException("")).when(transactionService).loadTransactions(any(Transaction.class));

		mvc.perform(post("/api/transactions").contentType("application/json")
				.content("{\"amount\": 12.3,\"timestamp\": 0}")).andExpect(status().isNoContent())
				.andExpect(content().bytes(new byte[0]));
		verify(transactionService).loadTransactions(ImmutableTransaction.of(12.3, 1478192204000L));
	}
}