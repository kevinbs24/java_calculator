package calculator.swing;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

    public JButton leftParenButton = new JButton("(");
    public JButton rightParenButton = new JButton(")");
    public JButton nineButton = new JButton("9");
    public JButton eightButton = new JButton("8");
    public JButton sevenButton = new JButton("7");
    public JButton sixButton = new JButton("6");
    public JButton fiveButton = new JButton("5");
    public JButton fourButton = new JButton("4");
    public JButton threeButton = new JButton("3");
    public JButton twoButton = new JButton("2");
    public JButton oneButton = new JButton("1");
    public JButton zeroButton = new JButton("0");
    public JButton plusButton = new JButton("+");
    public JButton minusButton = new JButton("-");
    public JButton timesButton = new JButton("*");
    public JButton divideButton = new JButton("/");
    public JButton equalsButton = new JButton("=");
    public JButton clearButton = new JButton("C");

    public ButtonPanel(ButtonHandler bh) {
        setLayout(new GridLayout(5, 4, 5, 5));

        add(leftParenButton);
        add(rightParenButton);
        add(clearButton);
        add(divideButton);

        add(nineButton);
        add(eightButton);
        add(sevenButton);
        add(timesButton);

        add(sixButton);
        add(fiveButton);
        add(fourButton);
        add(minusButton);

        add(threeButton);
        add(twoButton);
        add(oneButton);
        add(plusButton);

        add(zeroButton);
        add(equalsButton);

        // register listeners
        for (var c : getComponents()) {
            ((JButton) c).addActionListener(bh);
        }
    }
}
