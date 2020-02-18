/**
 * 
 */
package com.leovegas.transaction.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.leovegas.model.TransactionRequest;
import com.leovegas.services.TransactionService;

/**
 * @author ayush.a.mittal
 *
 */
@RunWith(PowerMockRunner.class)
class TransactionControllerTest {
	
	
	
	
	
	private TransactionService service = Mockito.mock(TransactionService.class); 

	@InjectMocks
	private TransactionController controller;
	
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		TransactionRequest response = new TransactionRequest();
		TransactionRequest response1 = new TransactionRequest();
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	/**
	 * Test method for {@link com.leovegas.transaction.controller.TransactionController#createTransaction(com.leovegas.model.TransactionRequest, java.lang.String)}.
	 */
	@Test
	@Ignore
	void testCreateTransaction() {

		try {

			
			

			when(service.createTransaction(any(TransactionRequest.class))).thenReturn(any(TransactionRequest.class));
			// When
			mockMvc.perform(MockMvcRequestBuilders.post("/transactions").accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON)
					.content(new TransactionRequest().toString()))
					.andExpect(status().isCreated());// Then

			verify(service, times(1)).createTransaction(any(TransactionRequest.class));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	
		
	}

	/**
	 * Test method for {@link com.leovegas.transaction.controller.TransactionController#getTransaction(java.lang.String)}.
	 */
	@Test
	@Ignore
	void testGetTransaction() {
	}

	/**
	 * Test method for {@link com.leovegas.transaction.controller.TransactionController#getTransactions(java.lang.String)}.
	 */
	@Test
	@Ignore
	void testGetTransactions() {
	}

}
