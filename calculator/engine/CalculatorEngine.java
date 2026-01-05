package calculator.engine;

import java.util.Stack;

public class CalculatorEngine {

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private void applyTop(Stack<Double> values, Stack<Operator> operators) {
		double b = values.pop();
		double a = values.pop();
		Operator op = operators.pop();
		values.push(op.apply(a, b));
	}

	public void inputNumber(double num) {

	}

	public void inputOperator(String op) {

	}

	public void clear() {

	}

	public double evaluate(String expression) {
		Stack<Double> values = new Stack<>();
		Stack<Operator> operators = new Stack<>();

		int i = 0;

		while (i < expression.length()) {
			char ch = expression.charAt(i);

			// Skip spaces
			if (ch == ' ') {
				i++;
				continue;
			}

			// Parse number (multi-digit)
			if (Character.isDigit(ch)) {
				StringBuilder sb = new StringBuilder();

				while (i < expression.length()
						&& (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
					sb.append(expression.charAt(i));
					i++;
				}

				values.push(Double.parseDouble(sb.toString()));
				continue;
			}

			// Operator
			if (isOperator(ch)) {
				Operator current = Operator.fromChar(ch);

				while (!operators.isEmpty() && operators.peek().precedence >= current.precedence) {
					applyTop(values, operators);
				}

				operators.push(current);
			}

			i++;
		}

		while (!operators.isEmpty()) {
			applyTop(values, operators);
		}

		return values.pop();
	}
}