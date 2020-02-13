/**
 * 
 */
package com.leovegas.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.leovegas.exception.RecordNotFoundException;
import com.leovegas.model.AccountDetails;
import com.leovegas.model.Direction;
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
	public TransactionRequest createTransaction(TransactionRequest request) throws RecordNotFoundException {
		
		//Check Account Details
		TransactionRequest response=null;
		AccountDetails accDetails=accRepo.getOne(request.getAccountNumber(), request.getPlayerId());
		if(null==accDetails) {
			throw new RecordNotFoundException("Account is not valid");
		}
		TransactionRequest txnReq=getTransaction(String.valueOf(request.getTransactionId()));
		if(null!=txnReq) {
			throw new RecordNotFoundException("Transaction is already there");
		}
			if(!checkCreditDebit(accDetails.getAmount(),request)) {
				throw new RecordNotFoundException("Bad Transaction");
			}
			Timestamp createdAt = new Timestamp(System.currentTimeMillis());
			request.setCreatedAt(createdAt);
			response=repository.save(request);
			accRepo.save(updateAccountAmount(accDetails, request));
		return response;
	}

	@Override
	public TransactionRequest getTransaction(String txnId) {
		TransactionRequest txnReq=null;
		Optional<TransactionRequest> response = repository.findById(Long.valueOf(txnId));
		if(response.isPresent()) {
			txnReq=response.get();
		}
		return txnReq;
	}
	
	
	private boolean checkCreditDebit(Long accountBalance,TransactionRequest txnReq) {
		
		if(txnReq.getDirection().getValue().equals(Direction.DEBIT.getValue())) {
			if(accountBalance==0 || accountBalance<0) {
				return false;
			}else if(accountBalance-txnReq.getAmount()<0) {
				return false;
			}
		}
		
		return true;
	}
	
	private AccountDetails updateAccountAmount(AccountDetails accDetails,TransactionRequest txnReq) {
		Long balance=0L;
		if(txnReq.getDirection().getValue().equals(Direction.DEBIT.getValue())) {
			balance=accDetails.getAmount()-txnReq.getAmount();
		}else if (txnReq.getDirection().getValue().equals(Direction.CREDIT.getValue())) {
			balance=accDetails.getAmount()+txnReq.getAmount();
		}
		accDetails.setAmount(balance);
		return accDetails;
	}

	@Override
	public List<TransactionRequest> getTransactions(String accntNumber) {
		TransactionRequest qRequest=new TransactionRequest();
		qRequest.setAccountNumber(accntNumber);
		return repository.findAll(Example.of(qRequest));
	}

}
