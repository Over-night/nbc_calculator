package v3;

import interfaces.InputManager;
import model.InputtedModification;
import enums.Menu;
import enums.Operator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManagerV3 implements InputManager<Double> {
    private final Scanner sc;

    public InputManagerV3() {
        sc = new Scanner(System.in);
    }

    private Operator checkValid(double second, String inputtedOperator) {
        if (inputtedOperator.length() != 1) {
            throw new IllegalArgumentException("Invalid operator.");
        }

        char code = inputtedOperator.charAt(0);
        Operator operator = null;

        if (code == Operator.PLUS.getFlag()) operator = Operator.PLUS;
        if (code == Operator.MINUS.getFlag()) operator = Operator.MINUS;
        if (code == Operator.MULTIPLY.getFlag()) operator = Operator.MULTIPLY;
        if (code == Operator.DIVIDE.getFlag()) operator = Operator.DIVIDE;

        if (operator == null) throw new IllegalArgumentException("Invalid operator.");

        if (second == 0f && operator == Operator.DIVIDE) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        return operator;
    }

    @Override
    public InputtedModification<Double> inputModification() {
        double firstOperand = 0f;
        double secondOperand = 0f;
        Operator operator;

        while (true){
            try {
                System.out.print(">>> Enter first operand: ");
                firstOperand = sc.nextDouble();
                System.out.print(">>> Enter second operand: ");
                secondOperand = sc.nextDouble();
                System.out.print(">>> Enter operator: ");
                String inputtedOperator = sc.next();

                try {
                    operator = checkValid(secondOperand, inputtedOperator);
                }
                catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input value (" + e.getMessage() + ")");
                sc.nextLine();
            }
        }

        return new InputtedModification<Double>(firstOperand, secondOperand, operator);
    }

    @Override
    public Double inputTarget() {
        Double target = null;

        while (true){
            try {
                System.out.print(">>> Enter value to search: ");
                target = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }

        return target;
    }

    public Menu inputMenu() {
        String command;

        System.out.println("< Menu Manager >");
        System.out.println("1. Calculate");
        System.out.println("2. Show All Data");
        System.out.println("3. Show First Data");
        System.out.println("4. Show Recent Data");
        System.out.println("5. Delete All Data");
        System.out.println("6. Delete First Data");
        System.out.println("7. Delete Recent Data");
        System.out.println("8. Search that bigger than inputted value");
        System.out.println("9. Search that smaller than inputted value");
        System.out.println("0. Exit");

        while (true) {
            System.out.print("Select: ");
            command = sc.next();

            switch (command) {
                case "1":
                case "Calculate":
                case "1. Calculate":
                    return Menu.CALCULATE;
                case "2":
                case "Show All Data":
                case "2. Show All Data":
                    return Menu.SHOW_ALL;
                case "3":
                case "Show First Data":
                case "3. Show First Data":
                    return Menu.SHOW_FIRST;
                case "4":
                case "Show Recent Data":
                case "4. Show Recent Data":
                    return Menu.SHOW_LAST;
                case "5":
                case "Delete All Data":
                case "5. Delete All Data":
                    return Menu.DELETE_ALL;
                case "6":
                case "Delete First Data":
                case "6. Delete First Data":
                    return Menu.DELETE_FIRST;
                case "7":
                case "Delete Recent Data":
                case "7. Delete Recent Data":
                    return Menu.DELETE_LAST;
                case "8":
                case "Search that bigger than inputted value":
                case "8. Search that bigger than inputted value":
                    return Menu.SEARCH_BIGGER;
                case "9":
                case "Search that smaller than inputted value":
                case "9. Search that smaller than inputted value":
                    return Menu.SEARCH_SMALLER;
                case "0":
                case "Exit":
                case "exit":
                case "0. Exit":
                    return Menu.EXIT;
                default:
                    System.out.println("Error : Invalid menu type. Please try again.");
            }
        }
    }
}
