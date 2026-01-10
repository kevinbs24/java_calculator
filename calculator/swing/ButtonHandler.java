package calculator.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculator.controller.CalculatorController;

public class ButtonHandler implements ActionListener {

    private final UserInterface ui;
    private final CalculatorController controller;

    public ButtonHandler(UserInterface ui) {
        this.ui = ui;
        this.controller = new CalculatorController(ui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	String cmd = e.getActionCommand();

    	switch (cmd) {
    	    case "(" -> controller.appendToDisplay("(");
    	    case ")" -> controller.appendToDisplay(")");
    	    case "+" -> controller.onOperatorPressed("+");
    	    case "-" -> controller.onOperatorPressed("-");
    	    case "*" -> controller.onOperatorPressed("*");
    	    case "/" -> controller.onOperatorPressed("/");
    	    case "=" -> controller.onEqualsPressed();
    	    case "C" -> controller.onClearPressed();
    	    default -> controller.onDigitPressed(cmd);
    	}

    }
}
