package com.incubyte.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class StringCalculatorTest {

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

}
