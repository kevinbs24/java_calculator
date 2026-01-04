package calculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UserInterface extends JFrame {

	Font displayFont = new Font("Arial", Font.BOLD, 18);
	ButtonHandler bh = new ButtonHandler(this);
	Container c = getContentPane();
	JTextArea display = new JTextArea();
	String displayText = "";
	JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
	JButton nineButton = new JButton("9");
	JButton eightButton = new JButton("8");
	JButton sevenButton = new JButton("7");
	JButton sixButton = new JButton("6");
	JButton fiveButton = new JButton("5");
	JButton fourButton = new JButton("4");
	JButton threeButton = new JButton("3");
	JButton twoButton = new JButton("2");
	JButton oneButton = new JButton("1");
	JButton zeroButton = new JButton("0");
	JButton plusButton = new JButton("+");
	JButton minusButton = new JButton("-");
	JButton timesButton = new JButton("x");
	JButton divideButton = new JButton("/");
	JButton equalsButton = new JButton("=");
	JButton clearButton = new JButton("C");

	public UserInterface() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);

		display.setSize(300, 100);
		display.setFont(displayFont);
		display.setEditable(false);

		buttonPanel.add(nineButton);
		nineButton.addActionListener(bh);
		buttonPanel.add(eightButton);
		eightButton.addActionListener(bh);
		buttonPanel.add(sevenButton);
		sevenButton.addActionListener(bh);
		buttonPanel.add(plusButton);
		plusButton.addActionListener(bh);
		buttonPanel.add(sixButton);
		sixButton.addActionListener(bh);
		buttonPanel.add(fiveButton);
		fiveButton.addActionListener(bh);
		buttonPanel.add(fourButton);
		fourButton.addActionListener(bh);
		buttonPanel.add(minusButton);
		minusButton.addActionListener(bh);
		buttonPanel.add(threeButton);
		threeButton.addActionListener(bh);
		buttonPanel.add(twoButton);
		twoButton.addActionListener(bh);
		buttonPanel.add(oneButton);
		oneButton.addActionListener(bh);
		buttonPanel.add(timesButton);
		timesButton.addActionListener(bh);
		buttonPanel.add(equalsButton);
		equalsButton.addActionListener(bh);
		buttonPanel.add(zeroButton);
		zeroButton.addActionListener(bh);
		buttonPanel.add(clearButton);
		clearButton.addActionListener(bh);
		buttonPanel.add(divideButton);
		divideButton.addActionListener(bh);

		// This line is not necessary as BorderLayout is the default for JFrame anyway
		// c.setLayout(new BorderLayout());
		c.add(display, BorderLayout.PAGE_START);
		c.add(buttonPanel, BorderLayout.CENTER);

		// pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
