package hw2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Enter an expression for calculation\nBe careful, "
				+ "every value/operand/parenthesis should be separated\nby " 			//ask user for input
				+ "a whitespace and every opened parenthesis must be closed");
		
		Scanner scan = new Scanner(System.in);											//initialize Scanner

		while(true) {																	//infinite while loop until input is valid
			String expression = scan.nextLine();										//store input in String expression
			if (checkWhitespace(expression) && checkParenthesis(expression)) {			//check validity
				Algorithm twoStackAlgorithm = new Algorithm(expression);				//create Algorithm object, pass parameter to the constructor
				twoStackAlgorithm.calculate();											//invoke calculate method from Algorithm
				break;																	//break infinite while loop
			}
			else {
				System.out.println("Invalid input! Try again.");						//if input is invalid, tell user to input again, loop restarts
			}
		}
		
		scan.close();																	//close Scanner
	}
	
	
	public static boolean checkWhitespace(String exp) {									//function checks whether tokens are separated by whitespace
		String[] expArr = exp.split("");												//create String array of all characters
		int count = 0;																	//initialize count
		for (String token : expArr) {													//for-each loop to iterate through array
			if (token.equals(" ")) {													//if there is a whitespace
				count++;																//increment count
			}
		}
		String[] expNoWhitespace = exp.split(" ");										//create String array of all characters without whitespace	
		if (count == expNoWhitespace.length-1) {										//number of whitespace should be 1 less than number of characters
			return true;
		}
		return false;
	}
	
	public static boolean checkParenthesis(String exp) {								//function checks whether every parenthesis is closed
		String[] expArr = exp.split("");												//create String array of all characters
		int count1 = 0;																	//initialize count1 and count2
		int count2 = 0;
		for (String token : expArr) {
			if (token.equals("(")) {													//increment count1 for every opened parenthesis
				count1++;
			}
			else if (token.equals(")")) {												//increment count2 for every closed parenthesis
				count2++;
			}
		}
		if (count1 == count2) {															//if there is the same number of opened and closed 
			return true;																//parenthesis then input is valid
		}
		return false;
	}

}
