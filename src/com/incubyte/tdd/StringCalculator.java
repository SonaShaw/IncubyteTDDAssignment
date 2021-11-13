package com.incubyte.tdd;

public class StringCalculator {
	
	
	public StringCalculator() {}
	
	public int Add(String numbers) {
		int n = numbers.length();
		if(n==0)
			return 0;
		String delimeter = ",";
		
		int newLineIndex = numbers.indexOf("\n");
		
		while (newLineIndex >= 0) {
			if(newLineIndex==0 || newLineIndex==n-1)
				return -1;
			char previousCharacter = numbers.charAt(newLineIndex-1);
			char nextCharacter = numbers.charAt(newLineIndex+1);
			if(!(Character.isDigit(previousCharacter) || Character.isDigit(nextCharacter)) || 
					(previousCharacter==','||nextCharacter==','))
				return -1;
			newLineIndex = numbers.indexOf("\n", newLineIndex + 2);
		}

		
		String parsedNumbers = numbers.replace("\n", delimeter);
		String numberArray[] = parsedNumbers.split(delimeter);
		int sum = 0;
		for(String number : numberArray) {
			if(!number.equals("")) {
				int value = Integer.parseInt(number);
				sum = sum + value;
			}	
		}
		return sum;
	}
	
	

}
