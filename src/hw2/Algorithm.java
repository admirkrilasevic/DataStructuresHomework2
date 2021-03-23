package hw2;

public class Algorithm {
	
	private String expression; 						//storing the expression from user
	private Stack<String> operators; 				//storing operators from expression
	private Stack<Integer> values; 					//storing values from expression
	
	public Algorithm(String expression) {			//initializing variables in the constructor
		this.expression = expression;
		this.operators = new Stack<String>();
		this.values = new Stack<Integer>();
	}
	
	
	public void calculate() {						//method calculate implements the algorithm
		
		String[] exprList = expression.split(" "); 	//a String array is created from expression, with whitespace as delimiter
		
		for (String token : exprList) { 			//for-each loop to iterate the array 
			if (token.equals("(")) {				//token = open bracket - do nothing
				
			}
			else if (token.equals("*")) {			//token = multiplication symbol - push to operators stack
				operators.push(token);
			}
			else if (token.equals("+")) {			//token = addition symbol - push to operators stack
				operators.push(token);
			}
			else if (token.equals("-")) {			//token = subtraction symbol - push to operators stack
				operators.push(token);
			}
			else if (token.equals("/")) {			//token = division symbol - push to operators stack
				operators.push(token);
			}
			else if (token.equals("%")) {			//token = modulo symbol - push to operators stack
				operators.push(token);
			}
			
			else if (token.equals(")")) {			//token = closed bracket - perform operation:
				int value = values.pop();			//pop value from stack values
	            String operator = operators.pop();	//pop operator from stack operators
	            if (operator.equals("+")) {			//within the if-else statements, another value will be popped from stack values
	                value = values.pop() + value;	//and operation will be performed based on given operator
	            } else if (operator.equals("-")) {
	                value = values.pop() - value;
	            } else if (operator.equals("*")) {
	                value *= values.pop();
	            } else if (operator.equals("/")) {
	                value = values.pop() / value;
	            }
	            else {
	            	value = values.pop() % value;
	            }
	            values.push(value); 				//after performing operation, push result (value) to stack values
			}
			else if (token.matches("[0-9]*")){		//token = number - convert from String to integer and push to values stack
				values.push(Integer.parseInt(token)); //maybe use "\\d+(\\.\\d*)?" as regex so it could be double instead of integer
			}
			else {
				throw new IllegalArgumentException("Unknown token"); //if the token is not a digit/parenthesis/known operator, throw exception
			}
		}
		System.out.println(values.pop()); 			//print the final value (result of expression) in the values stack to the user
	}
	
}
