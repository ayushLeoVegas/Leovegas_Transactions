/**
 * 
 */
package com.leovegas.services;

import com.leovegas.model.TransactionRequest;

/**
 * @author ayush.a.mittal
 *
 */
public interface TransactionService {

	
	public TransactionRequest createTransaction(TransactionRequest request);
	
	public TransactionRequest getTransaction(String txnId);
}
