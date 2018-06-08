package com.ankit.solutions.n26;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


	@SpringBootTest
	@RunWith(SpringRunner.class)
	public class ApplicationTest {

	    @Autowired
	    private ApplicationContext context;

	    @Test
	    public void shouldCreateApplication() throws Exception {
	        assertThat(context, notNullValue());
	    }
}
