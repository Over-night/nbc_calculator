package v3;

import interfaces.InputManager;
import utils.InputtedModification;
import utils.Operator;

import java.util.Scanner;

public class InputManagerV3 implements InputManager<Double> {
    private final Scanner sc;

    public InputManagerV3() {
        sc = new Scanner(System.in);
    }

    private Operator checkValid(double first, double second, String inputtedOperator) {
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

    public InputtedModification<Double> inputModification() {
        double firstOperand = 0;
        double secondOperand = 0;
        Operator operator;

        while (true){
            try {
                System.out.print("Enter first operand: ");
                firstOperand = sc.nextDouble();
                System.out.print("Enter second operand: ");
                secondOperand = sc.nextDouble();
                System.out.print("Enter operator: ");
                String inputtedOperator = sc.next();

                try {
                    operator = checkValid(firstOperand, secondOperand, inputtedOperator);
                }
                catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }

        return new InputtedModification<Double>(firstOperand, secondOperand, operator);
    }

    public int inputMenu() {
        String inputtedData;

        System.out.println("< Menu Manager >");
        System.out.println("1. Calculate");
        System.out.println("2. Show All Data");
        System.out.println("3. Show Recent Data");
        System.out.println("4. Delete All Data");
        System.out.println("5. Delete first Data");
        System.out.println("0. Exit");

        while (true) {
            System.out.print("Select: ");
            inputtedData = sc.next();

            switch (inputtedData) {
                case "1":
                case "Calculate":
                case "1. Calculate":
                    return 1;
                case "2":
                case "Show All Data":
                case "2. Show All Data":
                    return 2;
                case "3":
                case "Show Recent Data":
                case "3. Show Recent Data":
                    return 3;
                case "4":
                case "Delete All Data":
                case "4. Delete All Data":
                    return 4;
                case "5":
                case "Delete first Data":
                case "5. Delete first Data":
                    return 5;
                case "0":
                case "Exit":
                case "exit":
                case "0. Exit":
                    return 0;
                default:
                    System.out.println("Error : Invalid menu type. Please try again.");
            }
        }
    }
}
