package com.incubyte.tdd;

public class StringCalculator {
	
	
	public StringCalculator() {}
	
	public int Add(String numbers) {
		if(numbers.length()==0)
			return 0;
		String numberArray[] = numbers.split(",");
		int sum = 0;
		for(String number : numberArray) {
			int value = Integer.parseInt(number);
			sum = sum + value;
		}
		return sum;
	}
	
	

}
