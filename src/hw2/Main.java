package hw2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Enter an expression for calculation\nBe careful, every value/operand/parenthesis should be separated\nby a whitespace and every opened parenthesis must be closed");
		Scanner scan = new Scanner(System.in);

		while(true) {
			String expression = scan.nextLine();
			if (checkWhitespace(expression) && checkParenthesis(expression)) {
				Algorithm a1 = new Algorithm(expression);
				a1.calculate();
				break;
			}
			else {
				System.out.println("Invalid input! Try again.");
			}
		}
	}
	
	
	public static boolean checkWhitespace(String s) {
		String[] expr = s.split("");
		int count = 0;
		for (String token : expr) {
			if (token.equals(" ")) {
				count++;
			}
		}
		String[] exprNoWhitespace = s.split(" ");
		if (count == exprNoWhitespace.length-1) {
			return true;
		}
		return false;
	}
	
	public static boolean checkParenthesis(String s) {
		String[] expr = s.split("");
		int count1 = 0;
		int count2 = 0;
		for (String token : expr) {
			if (token.equals("(")) {
				count1++;
			}
			else if (token.equals(")")) {
				count2++;
			}
		}
		if (count1 == count2) {
			return true;
		}
		else {
			return false;
		}
	}

}
