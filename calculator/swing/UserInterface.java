package calculator.swing;

import java.awt.*;
import javax.swing.*;

public class UserInterface extends JFrame {

    private final JTextArea display = new JTextArea();
    private String displayText = "";

    public UserInterface() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        display.setFont(new Font("Arial", Font.BOLD, 18));
        display.setEditable(false);

        add(display, BorderLayout.PAGE_START);
        ButtonHandler bh = new ButtonHandler(this);

        add(new ButtonPanel(bh), BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String text) {
        this.displayText = text;
        display.setText(text);
    }
}
