package v2;

import java.util.Scanner;

public class InputManagerV2 {
    private final Scanner sc;

    public InputManagerV2() {
        sc = new Scanner(System.in);
    }

    private void checkValid(double first, double second, String inputtedOperator) {
        if (inputtedOperator.length() != 1) {
            throw new IllegalArgumentException("Invalid operator.");
        }

        char operator = inputtedOperator.charAt(0);

        if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
            throw new IllegalArgumentException("Invalid operator.");
        }

        if (second == 0f && operator == '/') {
            throw new ArithmeticException("Cannot divide by zero.");
        }
    }

    public InputtedModificationV2 inputModification() {
        double firstOperand = 0;
        double secondOperand = 0;
        char operator = ' ';

        while (true){
            try {
                System.out.print("Enter first operand: ");
                firstOperand = sc.nextDouble();
                System.out.print("Enter second operand: ");
                secondOperand = sc.nextDouble();
                System.out.print("Enter operator: ");
                String inputtedOperator = sc.next();

                try {
                    checkValid(firstOperand, secondOperand, inputtedOperator);
                    operator = inputtedOperator.charAt(0);
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

        return new InputtedModificationV2(firstOperand, secondOperand, operator);
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
