/**
 * 
 */
package com.leovegas.services;

import com.leovegas.exception.RecordNotFoundException;
import com.leovegas.model.TransactionRequest;

/**
 * @author ayush.a.mittal
 *
 */
public interface TransactionService {

	
	public TransactionRequest createTransaction(TransactionRequest request) throws RecordNotFoundException;
	
	public TransactionRequest getTransaction(String txnId);
}
