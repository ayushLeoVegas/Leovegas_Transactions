package com.leovegas.model;

public enum Direction {
	CREDIT("CREDIT"), DEBIT("DEBIT");
	private String value;

	Direction(String value) {
		this.value = value;
	}
	
	public String getValue(){
		  return value;
		 }
}
