package com.leovegas.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="TRANSACTION_DETAILS")
@Validated
public class TransactionRequest {

	@Id
	@Column(name="transaction_id")
	private Long transactionId;
	
	@Column(name="amount")
	@NotNull
	private Long amount;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="direction")
	@NotNull
	@Enumerated(EnumType.STRING)
	private Direction direction;
	
	@Column(name="currency")
	@NotNull
	@NotEmpty
	private String currency;
	
	@Column(name="player_id")
	private String playerId;
	
	@Column(name="account_number")
	@NotNull
	@NotEmpty
	private String accountNumber;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	
}
