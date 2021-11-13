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
	
	//Test for Allow the Add method to handle new lines between numbers (instead of commas).
	@Test
	void handleNewLinesBetweenNumbersTests() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "1\n2,3";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 6);
		
		numbers = "45\n5,,1,";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 51);
		
		numbers = "50\n50,,1\n1,,1,";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 103);
		
		numbers = "45,50\n50,,1,";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 146);
		
		// -1 denotes --> Invalid input
		numbers = "1,\n";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "1,\n,45,5";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "\n45,,1,";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "45,50\n,,1,";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "45,50,,\n,,1,";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "45,\n,50,,\n,,1,";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "45,\n\n,50,,\n,\n\n,1,";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
	}
	
	//Test for Allow the Add method to support multiple delimeters.
	@Test
	void supportDifferentDelimeterTests() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "//;\n1;200;99";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 300);
		
		numbers = "//;\n1;200;50\n\n10;120";
		res = stringCalculator.Add(numbers);
		assertEquals(res, 381);
		
		//returns -1 that means invalid input because "\n" is not present between numbers
		numbers = "//;\n1;200;50\n;10;120";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "//;\n1;200;50\n,10;120";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "//;\n1;200;50\n\n,10;120";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
	}
	
	
	//Test to support Calling Add with a negative number will throw an exception "negatives not allowed" - and the negative that was passed.
	@Test
	void callingWithNegativeNumberTests() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "//;\n1;-2;-9";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
		
		numbers = "-10,5\n7,89,,,,9,-78";
		res = stringCalculator.Add(numbers);
		assertEquals(res, -1);
			
	}

}
