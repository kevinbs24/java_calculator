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

	public void numberPressed(String digit) {
		ui.displayText += digit;
		ui.display.setText(ui.displayText);
	}

	public void operatorPressed(String op) {
		ui.displayText += " " + op + " ";
		ui.display.setText(ui.displayText);
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