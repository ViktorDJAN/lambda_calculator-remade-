package org.example.calculator_logic;


public class Calculator {
    private String[] expressionElements;

    public Calculator() {
    }

    private Integer currentPosition;

    public Calculator(String mathExpression) {
        this.expressionElements = correctingRow(mathExpression).split(" ");
        this.currentPosition = 0;
    }

    /**
     * This method removes extra white spaces in the row and set one white space between each element of the list.
     */
    public String correctingRow(String anyRow) {
        String noWhiteSpaceRow = anyRow.replaceAll("\\s", "");
        noWhiteSpaceRow = noWhiteSpaceRow.replace("+", " + ");
        noWhiteSpaceRow = noWhiteSpaceRow.replace("-", " - ");
        noWhiteSpaceRow = noWhiteSpaceRow.replace("*", " * ");
        noWhiteSpaceRow = noWhiteSpaceRow.replace("/", " / ");
        noWhiteSpaceRow = noWhiteSpaceRow.replace("(", "( ");
        noWhiteSpaceRow = noWhiteSpaceRow.replace(")", " )");
        return noWhiteSpaceRow;

    }

    /**
     * This method in the beginning executes computing of multiplication and division , before addition and subtraction.
     */
    public Double compute() {
        Double firstItem = multypleAndDevide();
        while (currentPosition < expressionElements.length) {
            String operator = expressionElements[currentPosition];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                currentPosition++;
            }
            Double secondItem = multypleAndDevide();
            if (operator.equals("+")) {
                firstItem = additionOperation.process(firstItem, secondItem);
            }
            if (operator.equals("-")) {
                firstItem = substructureOperation.process(firstItem, secondItem);
            }

        }
        return firstItem;
    }

    /**
     * This method in the beginning processes a value in the brackets ,before computing of multiplication and division.
     */
    public Double multypleAndDevide() {
        Double firstItem = brackets();// a var got a value and increased itself
        while (currentPosition < expressionElements.length) {
            String operator = expressionElements[currentPosition];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                currentPosition++;
            }
            Double secondItem = brackets();
            if (operator.equals("*")) {
                firstItem = multiplicationOperation.process(firstItem, secondItem);
            }
            if (operator.equals("/")) {
                if (secondItem == 0) throw new ArithmeticException("Dividing by zero is impossible");
                firstItem = divisionOperation.process(firstItem, secondItem);
                ;
            }

        }
        return firstItem;
    }

    /**
     * This method checks availability of brackets in an expression , process and return its value.
     * In case of brackets absence it returns value of elements of array.
     */

    public Double brackets() {
        String bracket = expressionElements[currentPosition];
        if (bracket.equals("(")) {
            currentPosition++;
            Double result = compute();
            String oppositeBracket;
            oppositeBracket = expressionElements[currentPosition];
            if (oppositeBracket.equals(")")) {
                currentPosition++;
                return result;
            }
        }
        currentPosition++;
        return Double.parseDouble(bracket);
    }

    @FunctionalInterface
    interface Operator<T> {
        T process(T a, T b);
    }

    Operator<Double> additionOperation = (a, b) -> a + b;
    Operator<Double> substructureOperation = (a, b) -> a - b;
    Operator<Double> multiplicationOperation = (a, b) -> a * b;
    Operator<Double> divisionOperation = (a, b) -> a / b;


}
