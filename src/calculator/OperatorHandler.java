package calculator;

import java.util.Stack;

public class OperatorHandler {

	Stack<Double> values = new Stack<>();
	Stack<String> operators = new Stack<>();
	UserInterface ui;
	boolean startNewNumber = true;

	public OperatorHandler(UserInterface ui) {

		this.ui = ui;
	}

	private int precedence(String op) {
		if (op.equals("+") || op.equals("-"))
			return 1;
		if (op.equals("x") || op.equals("/"))
			return 2;
		return 0;
	}

	private void evaluateTop() {
		double b = values.pop();
		double a = values.pop();
		String op = operators.pop();

		double result = 0;

		switch (op) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "x":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		}

		values.push(result);
	}

	public void operatorPressed(String op) {
		double value = Double.parseDouble(ui.displayText);
		values.push(value);

		while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(op)) {
			evaluateTop();
		}

		operators.push(op);
		startNewNumber = true;
	}

	public void numberPressed(String digit) {

		if (startNewNumber == true) {
			ui.displayText = digit;
			startNewNumber = false;
		} else {
			ui.displayText += digit;
		}
		ui.display.setText(ui.displayText);
	}

	public void equalsPressed() {
		values.push(Double.parseDouble(ui.displayText));

		while (!operators.isEmpty()) {
			evaluateTop();
		}

		double result = values.pop();
		ui.displayText = String.valueOf(result);
		ui.display.setText(ui.displayText);

		startNewNumber = true;
	}

	public void clearPressed() {

		values.clear();
		operators.clear();
		ui.displayText = "";
		ui.display.setText(ui.displayText);
		startNewNumber = true;
	}
}
