package EngageExercises.SimpleCalculator;

import Other.CLMenu.CLMenu;

import java.math.BigDecimal;

import static Other.ReadNumbers.ReadNumber;

public class App {
    final static String[] operators = {"Add", "Subtract", "Multiply", "Divide"};

    public static void main(String[] args) {
        System.out.println("Welcome to the SimpleCalculator");

        String[] mainMenu = {"Yes."};
        Runnable[] mainMenuMethod = {App::PerformCalculation};
        CLMenu CalculatorMenu = new CLMenu(mainMenu, mainMenuMethod);

        CalculatorMenu.setExitMessage("No.");
        CalculatorMenu.setStartMessage("Would you like to perform a calculation?");

        CalculatorMenu.StartMenu();
    }

    private static void PerformCalculation() {
        SimpleCalculator calculator = new SimpleCalculator();

        BigDecimal a = ReadNumber();
        BigDecimal b = ReadNumber();

        String operator;

        Runnable[] operatorMethods = new Runnable[] {
                () -> {
                    BigDecimal result = calculator.add(a, b);
                    System.out.println(a + " + " + b + " = " + result.toString());
                },
                () -> {
                    BigDecimal result = calculator.subtract(a, b);
                    System.out.println(a + " - " + b + " = " + result.toString());
                },
                () -> {
                    BigDecimal result = calculator.multiply(a, b);
                    System.out.println(a + " x " + b + " = " + result.toString());
                },
                () -> {
                    BigDecimal result = calculator.divide(a, b);
                    System.out.println(a + " / " + b + " = " + result.toString());
                },
        };

        CLMenu operatorMenu = new CLMenu(operators, operatorMethods);
        operatorMenu.StartMenu(false);
    }
}
