package com.incubyte.tdd;

public class NegativeNumberException extends Exception{
	private String details;
	NegativeNumberException(String details){
		this.details = details;
	}
	public String toString() {
		return "negatives not allowed - "+details;
	}
}
