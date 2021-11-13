package com.incubyte.tdd;

public class StringCalculator {
	
	
	public StringCalculator() {}
	
	public int Add(String numbers) {
		int n = numbers.length();
		if(n==0)
			return 0;
		String delimeter = ",";
		
		//Check for different type of delimeter
		if(n>=2 && numbers.substring(0,2).equals("//")) {
			//check for delimeter of any length
			int index = numbers.indexOf("\n");  
			delimeter = numbers.charAt(2)+"";
			numbers = numbers.substring(index+1, numbers.length());
		}
		
		int newLineIndex = numbers.indexOf("\n");
		
		// handle new lines between numbers
		while (newLineIndex >= 0) {
			if(newLineIndex==0 || newLineIndex==n-1)
				return -1;
			char previousCharacter = numbers.charAt(newLineIndex-1);
			char nextCharacter = numbers.charAt(newLineIndex+1);
			if(!(Character.isDigit(previousCharacter) || Character.isDigit(nextCharacter)) || 
					(previousCharacter==','||nextCharacter==',') ||
					(previousCharacter==delimeter.charAt(0)||nextCharacter==delimeter.charAt(0)))
				return -1;
			newLineIndex = numbers.indexOf("\n", newLineIndex + 1);
		}

		
		String parsedNumbers = numbers.replace("\n", delimeter);
		String numberArray[] = parsedNumbers.split(delimeter);
		int sum = 0;
		try {
			boolean isNegativeValue = false;
			String negativeValues = "";
			for(String number : numberArray) {
				if(!number.equals("")) {
					int value = Integer.parseInt(number);
					// handle if any number is negative
					if(value<0) {
						if(!isNegativeValue)
							isNegativeValue = true;
						negativeValues = negativeValues+value+" ";
					}
					// ignore number greater than 1000
					if(value<=1000)
						sum = sum + value;
				}	
			}
			// Throw exception if the string contains negative number/s
			if(isNegativeValue)
				throw new NegativeNumberException(negativeValues);
		}catch (NegativeNumberException e) {
			System.out.println(e);
			return -1;
		}
		
		return sum;
	}
	
	

}
