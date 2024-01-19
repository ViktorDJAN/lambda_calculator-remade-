package org.example.app;


import org.example.calculator_logic.Calculator;
import org.example.view.View;

public class App {
    public void runCalculator() {
        View view = new View();
        view.greeting();
        Calculator calculator = new Calculator(view.enteringExpression());
        view.printResult(calculator.compute());
    }
}