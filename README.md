# Java Calculator Project

This repository documents my progression from a simple console-based Java calculator
to a GUI-based Swing calculator with structured operator handling.

## Versions

### v0.1 – Console Calculator
- Text-based user input using Scanner
- Supports add, subtract, multiply, divide
- Uses loops and switch statements
- Focuses on control flow and input validation

### v0.2 – Swing GUI Calculator (In Progress)
- Built with Java Swing
- Button-based input
- Separated UI, input handling, and operator logic
- Preparing for order-of-operations (PEMDAS)

## Goals
- Demonstrate incremental software development
- Practice refactoring and architectural improvements
- Learn proper Git version control workflows

## Java Calculator (v1.0)
A desktop calculator application written in Java with a custom expression evaluation engine supporting operator precedence (PEMDAS) and parentheses.
This project was built to understand and implement expression parsing and evaluation without relying on built-in scripting or evaluation shortcuts.

Features:
Multi-digit number parsing
Decimal number support
Operator precedence (PEMDAS)
Parentheses handling
Stack-based expression evaluation
Java Swing graphical user interface
Clean separation between UI and calculation logic

Architecture Overview:
calculator.engine
- CalculatorEngine      // Parses and evaluates expressions
- Operator              // Operator definitions and precedence

calculator.swing
- UserInterface         // Swing layout and display
- ButtonHandler         // Button event handling

calculator
- OperatorHandler       // UI → Engine coordination
- Main                  // Application entry point

Example Expressions
2 + 3 * 4        → 14
(2 + 3) * 4      → 20
10 / (5 - 3)     → 5

Design Notes:
The calculation engine is completely UI-agnostic and can be reused in other projects.
Expression evaluation is implemented using two stacks (values and operators).
Parentheses are handled explicitly within the operator stack.
Future Improvements (Out of Scope)
Scientific functions
Memory operations
Graphing
Keyboard input support
These would be treated as separate projects or major version upgrades.

Status
v1.0 — Complete
This version represents a stable, finished implementation of the original project goal.
- Prepare for more complex projects (Task Manager, 2D Java Game)

## Planned Improvements
- Order of operations (PEMDAS)
- Decimal input support
- Keyboard input
- Improved UI layout
- Error handling
