package org.example.view;

import java.util.Scanner;

public class View {

    private String someExpression;

    public View() {

    }
    public void greeting(){
        System.out.println("This app is a console calculator");
        System.out.println("There are math operators here you can utilize : + , - , * , / , ( , )");
        System.out.println("All what you need to do is write the mathematical expression in the proper sequence.");
        System.out.println("e.g something like this   2*5*(10+2)");
    }

    public void printResult(Double result){
        System.out.println("The result = "+ result);
    }


    public String enteringExpression(){
        System.out.println("Enter what you want to compute");
        Scanner scanner = new Scanner(System.in);
        return this.someExpression = scanner.next();
    }
}
