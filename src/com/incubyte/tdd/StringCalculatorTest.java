package com.incubyte.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;




class StringCalculatorTest {

	//===========Test fot point 1  (handle basic string)
	@Test
	void testForBasicString() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 0);
		
		numbers = "1";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 1);
		
		numbers = "1,2";	
		res = stringCalculator.Add(numbers);
		assertEquals(res, 3);
		
		//test if the string contains only "," 
		numbers = ",";	
		res = stringCalculator.Add(numbers);
		assertEquals(res, 0);
		
		numbers = ",,,,,,";	
		res = stringCalculator.Add(numbers);
		assertEquals(res, 0);
	}
	
	// Test for point 2 (handle unknown amount of number)
	@Test
	void unownAmountofNumberstests() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "5000,50000";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 55000);
		
		numbers = "100000,100000";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 200000);
		
		numbers = "678951,8963213";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 9642164);
		
		numbers = "789001,8967213";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 9756214);
	}

}
