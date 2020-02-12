/**
 * 
 */
package com.leovegas.services.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leovegas.model.AccountDetails;
import com.leovegas.model.TransactionRequest;
import com.leovegas.services.TransactionService;
import com.leovegas.transaction.repository.AccountRepository;
import com.leovegas.transaction.repository.TransactionRepository;

/**
 * @author ayush.a.mittal
 *
 */

@Component
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private AccountRepository accRepo;
	
	@Override
	public TransactionRequest createTransaction(TransactionRequest request) {
		
		//Check Account Details
		TransactionRequest response=null;
		AccountDetails accDetails=accRepo.getOne(request.getAccountNumber(), request.getPlayerId());
		if(null!=accDetails) {
			Timestamp createdAt = new Timestamp(System.currentTimeMillis());
			request.setCreatedAt(createdAt);
			response=repository.save(request);
		}
		
		return response;
	}

	@Override
	public TransactionRequest getTransaction(String txnId) {
		return repository.findById(Long.valueOf(txnId)).get();
	}

}
