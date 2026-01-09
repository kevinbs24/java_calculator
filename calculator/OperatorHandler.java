package calculator;

import calculator.engine.CalculatorEngine;
import calculator.swing.UserInterface;

public class OperatorHandler {

	private final CalculatorEngine engine;
	private final UserInterface ui;

	public OperatorHandler(UserInterface ui) {
		this.ui = ui;
		this.engine = new CalculatorEngine();
	}
	
	public void append(String text) {
	    ui.displayText += text;
	    ui.display.setText(ui.displayText);
	}

	public void numberPressed(String digit) {
	    append(digit);
	}

	public void operatorPressed(String op) {
	    append(" " + op + " ");
	}

	public void equalsPressed() {
		try {
			double result = engine.evaluate(ui.displayText);
			ui.displayText = String.valueOf(result);
			ui.display.setText(ui.displayText);
		} catch (Exception e) {
			ui.displayText = "Error";
			ui.display.setText(ui.displayText);
		}
	}

	public void clearPressed() {
		ui.displayText = "";
		ui.display.setText(ui.displayText);
	}
}