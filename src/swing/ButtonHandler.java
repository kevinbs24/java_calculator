package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {

	UserInterface ui;
	OperatorHandler oh;

	public ButtonHandler(UserInterface ui) {

		this.ui = ui;
		this.oh = new OperatorHandler(ui);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ui.nineButton) {
			oh.numberPressed("9");
		}
		if (e.getSource() == ui.eightButton) {
			oh.numberPressed("8");
		}
		if (e.getSource() == ui.sevenButton) {
			oh.numberPressed("7");
		}
		if (e.getSource() == ui.sixButton) {
			oh.numberPressed("6");
		}
		if (e.getSource() == ui.fiveButton) {
			oh.numberPressed("5");
		}
		if (e.getSource() == ui.fourButton) {
			oh.numberPressed("4");
		}
		if (e.getSource() == ui.threeButton) {
			oh.numberPressed("3");
		}
		if (e.getSource() == ui.twoButton) {
			oh.numberPressed("2");
		}
		if (e.getSource() == ui.oneButton) {
			oh.numberPressed("1");
		}
		if (e.getSource() == ui.zeroButton) {
			oh.numberPressed("0");
		}
		if (e.getSource() == ui.plusButton) {
			oh.operatorPressed("+");
		}
		if (e.getSource() == ui.minusButton) {
			oh.operatorPressed("-");
		}
		if (e.getSource() == ui.timesButton) {
			oh.operatorPressed("x");
		}
		if (e.getSource() == ui.divideButton) {
			oh.operatorPressed("/");
		}
		if (e.getSource() == ui.equalsButton) {
			oh.equalsPressed();
		}
		if (e.getSource() == ui.clearButton) {
			oh.clearPressed();
		}
	}

}
