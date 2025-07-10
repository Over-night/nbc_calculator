package v2;

import utils.BooleanWithMessage;
import utils.ComputationalData;

import java.util.Scanner;

public class InputManager {
    private final Scanner sc;

    public InputManager() {
        sc = new Scanner(System.in);
    }

    private BooleanWithMessage checkValid(float first, float second, String inputtedOperator) {
        if (inputtedOperator.length() != 1) {
            return new BooleanWithMessage(false, "Error : Invalid operator.");
        }

        char operator = inputtedOperator.charAt(0);

        if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
            return new BooleanWithMessage(false, "Error: Invalid operator.");
        }

        if (second == 0f && operator == '/') {
            return new BooleanWithMessage(false, "Error: Cannot divide by zero.");
        }

        return new BooleanWithMessage(true, "");
    }

    public ComputationalData inputData() {
        boolean valid = false;

        float firstOperand = 0;
        float secondOperand = 0;
        char operator = 0;

        do {
            try {
                System.out.print("Enter first operand: ");
                firstOperand = sc.nextFloat();
                System.out.print("Enter second operand: ");
                secondOperand = sc.nextFloat();
                System.out.print("Enter operator: ");
                String inputtedOperator = sc.next();

                BooleanWithMessage dataValid = checkValid(firstOperand, secondOperand, inputtedOperator);
                if (dataValid.isValid) {
                    operator = inputtedOperator.charAt(0);
                    valid = true;
                } else {
                    System.out.println(dataValid.message);
                }
            } catch (Exception e) {
                System.out.println("Error: Entered data's type is invalid");
                sc.nextLine();
            }
        } while (!valid);

        return new ComputationalData(firstOperand, secondOperand, operator);
    }

    public BooleanWithMessage inputMenu() {
        boolean valid = false;
        BooleanWithMessage result = new BooleanWithMessage(true, "Error occurred");
        String inputtedData;

        System.out.println("< Menu Manager >");
        System.out.println("1. Calculate");
        System.out.println("2. Show All Data");
        System.out.println("3. Show Recent Data");
        System.out.println("4. Delete All Data");
        System.out.println("5. Delete first Data");
        System.out.println("0. Exit");

        do {
            System.out.print("Select: ");
            inputtedData = sc.next();

            switch (inputtedData) {
                case "1":
                case "Calculate":
                case "1. Calculate":
                    result = new BooleanWithMessage(true, "inputData");
                    valid = true;
                    break;
                case "2":
                case "Show All Data":
                case "2. Show All Data":
                    result = new BooleanWithMessage(true, "getResults");
                    valid = true;
                    break;
                case "3":
                case "Show Recent Data":
                case "3. Show Recent Data":
                    result = new BooleanWithMessage(true, "getResult");
                    valid = true;
                    break;
                case "4":
                case "Delete All Data":
                case "4. Delete All Data":
                    result = new BooleanWithMessage(true, "deleteResults");
                    valid = true;
                    break;
                case "5":
                case "Delete first Data":
                case "5. Delete first Data":
                    result = new BooleanWithMessage(true, "deleteResult");
                    valid = true;
                    break;
                case "0":
                case "Exit":
                case "0. Exit":
                    result = new BooleanWithMessage(false, "exit");
                    valid = true;
                    break;
                default:
                    System.out.println("Error : Invalid menu type. Try again.");
            }
        } while (!valid);

        return result;
    }
}
