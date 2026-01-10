package calculator.engine;

import java.util.Stack;

/**
 * Evaluates arithmetic expressions using a stack-based algorithm.
 * Supports:
 * - +, -, *, /
 * - Operator precedence (PEMDAS)
 * - Parentheses, including nested expressions
 */
public class CalculatorEngine {

    public double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Operator> operators = new Stack<>();

        int i = 0;

        while (i < expression.length()) {
            char ch = expression.charAt(i);

            // Ignore whitespace
            if (ch == ' ') {
                i++;
                continue;
            }

            // Left parenthesis blocks operator precedence
            if (ch == '(') {
                operators.push(Operator.LEFT_PAREN);
                i++;
                continue;
            }

            // Resolve until matching '('
            if (ch == ')') {
                while (!operators.isEmpty()
                        && operators.peek() != Operator.LEFT_PAREN) {
                    applyTop(values, operators);
                }
                operators.pop(); // remove '('
                i++;
                continue;
            }

            // Parse multi-digit numbers (and decimals)
            if (Character.isDigit(ch)) {
                StringBuilder numberBuffer = new StringBuilder();

                while (i < expression.length()
                        && (Character.isDigit(expression.charAt(i))
                        || expression.charAt(i) == '.')) {
                    numberBuffer.append(expression.charAt(i));
                    i++;
                }

                values.push(Double.parseDouble(numberBuffer.toString()));
                continue;
            }

            // Operator handling with precedence
            if (isOperator(ch)) {
                Operator current = Operator.fromChar(ch);

                while (!operators.isEmpty()
                        && operators.peek() != Operator.LEFT_PAREN
                        && operators.peek().precedence >= current.precedence) {
                    applyTop(values, operators);
                }

                operators.push(current);
            }

            i++;
        }

        // Apply remaining operators
        while (!operators.isEmpty()) {
            applyTop(values, operators);
        }

        return values.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private void applyTop(Stack<Double> values, Stack<Operator> operators) {
        double b = values.pop();
        double a = values.pop();
        Operator op = operators.pop();
        values.push(op.apply(a, b));
    }
}
