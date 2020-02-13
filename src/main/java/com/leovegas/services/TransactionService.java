/**
 * 
 */
package com.leovegas.services;

import java.util.List;

import com.leovegas.exception.RecordNotFoundException;
import com.leovegas.model.TransactionRequest;

/**
 * @author ayush.a.mittal
 *
 */
public interface TransactionService {

	
	public TransactionRequest createTransaction(TransactionRequest request) throws RecordNotFoundException;
	
	public TransactionRequest getTransaction(String txnId);
	
	public List<TransactionRequest> getTransactions(String accntNumber);
}
