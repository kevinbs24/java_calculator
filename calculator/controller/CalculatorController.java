package calculator.controller;

import calculator.engine.CalculatorEngine;
import calculator.swing.UserInterface;

/**
 * Acts as the controller between the UI and the calculation engine.
 */
public class CalculatorController {

    private final CalculatorEngine engine;
    private final UserInterface ui;

    public CalculatorController(UserInterface ui) {
        this.ui = ui;
        this.engine = new CalculatorEngine();
    }

    public void appendToDisplay(String text) {
        ui.setDisplayText(ui.getDisplayText() + text);
    }

    public void onDigitPressed(String digit) {
        appendToDisplay(digit);
    }

    public void onOperatorPressed(String operator) {
        appendToDisplay(" " + operator + " ");
    }

    public void onEqualsPressed() {
        try {
            double result = engine.evaluate(ui.getDisplayText());
            ui.setDisplayText(String.valueOf(result));
        } catch (Exception e) {
            ui.setDisplayText("Error");
        }
    }

    public void onClearPressed() {
        ui.setDisplayText("");
    }
}
