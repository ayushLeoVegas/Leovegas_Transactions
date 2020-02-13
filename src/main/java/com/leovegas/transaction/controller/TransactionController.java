package com.leovegas.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leovegas.exception.RecordNotFoundException;
import com.leovegas.model.TransactionRequest;
import com.leovegas.services.TransactionService;

@Controller
@RequestMapping(value = "${microservice.context.path:}")
public class TransactionController {
	
	@Autowired
	private TransactionService service;

	@PostMapping(value = "/transactions",
	        produces = { "application/json; charset=utf-8" }
	        )
	public ResponseEntity<TransactionRequest> createTransaction(@Validated @RequestBody TransactionRequest request
			,@RequestHeader(name="Accept") String accept ) throws RecordNotFoundException{
		TransactionRequest response=service.createTransaction(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/transactions/{transactionId}",
	        produces = { "application/json; charset=utf-8" }
	        )
	public ResponseEntity<TransactionRequest> getTransaction(@PathVariable("transactionId") String transactionId){
		return  new ResponseEntity<>(service.getTransaction(transactionId), HttpStatus.OK);
	}
}
