package com.incubyte.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.incubyte.tdd.StringCalculator;

class StringCalculatorTest {

	@Test
	void test1() {
		StringCalculator stringCalculator = new StringCalculator();
		String numbers = "";
		int res = stringCalculator.Add(numbers);
		assertEquals(res, 0);
	}

}
