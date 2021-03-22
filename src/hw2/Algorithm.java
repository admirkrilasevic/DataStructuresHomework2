package hw2;

public class Algorithm {
	
	private String expression; //variable for storing the expression from user
	private Stack<String> operators;
	private Stack<Integer> values;
	
	public Algorithm(String expression) {
		this.expression = expression;
		this.operators = new Stack<String>();
		this.values = new Stack<Integer>();
	}
	
	public void calculate() {
		
		String[] exprList = expression.split(" ");
		
		for (String token : exprList) {
			if (token.equals("(")) {
				
			}
			else if (token.equals("*")) {
				operators.push(token);
			}
			else if (token.equals("+")) {
				operators.push(token);
			}
			else if (token.equals("-")) {
				operators.push(token);
			}
			else if (token.equals("/")) {
				operators.push(token);
			}
			else if (token.equals("%")) {
				operators.push(token);
			}
			
			else if (token.equals(")")) {
				int value = values.pop();
	            String operator = operators.pop();
	            if (operator.equals("+")) {
	                value = values.pop() + value;
	            } else if (operator.equals("-")) {
	                value = values.pop() - value;
	            } else if (operator.equals("*")) {
	                value *= values.pop();
	            } else if (operator.equals("/")) {
	                value = values.pop() / value;
	            } else if (operator.equals("%")) {
	                value = values.pop() % value;
	            }
	            values.push(value);
			}
			else if (token.matches("[0-9]*")){
				values.push(Integer.parseInt(token));
			}
		}
		System.out.println(values.pop());
	}
	
}
