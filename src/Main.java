import interfaces.Calculator;
import interfaces.InputManager;
import model.InputtedModification;
import enums.Menu;
import model.Result;
import v3.CalculatorV3;
import v3.InputManagerV3;

import java.util.ArrayList;

// V3
public class Main {

    public static void main(String[] args) {
        InputManager<Double> inputManager = new InputManagerV3();
        Calculator<Result, Double> calculator = new CalculatorV3();

        while (true) {
            Menu menu = inputManager.inputMenu();

            switch (menu) {
                case CALCULATE:
                        InputtedModification<Double> modification = inputManager.inputModification();
                        System.out.println(">>> Result : " + calculator.calculate(modification) + "\n");
                        break;
                case SHOW_ALL:
                        try {
                            ArrayList<Result> results = calculator.getAllResults();
                            System.out.println(">>> All result");
                            for (Result result : results)
                                System.out.println(result.toString());
                            System.out.println();
                        } catch(IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                case SHOW_FIRST:
                        try {
                            System.out.println(">>> First result: " + calculator.getFirstResult() + "\n");
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                    break;
                case SHOW_LAST:
                        try {
                            System.out.println(">>> Recent result: " + calculator.getLastResult() + "\n");
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                case DELETE_ALL:
                        try {
                            calculator.deleteAllResults();
                            System.out.println(">>> Delete All : All data is deleted\n");
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                case DELETE_FIRST:
                        try {
                            calculator.deleteFirstResult();
                            System.out.println(">>> Delete First : First data is deleted\n");
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                case DELETE_LAST:
                        try {
                            calculator.deleteLastResult();
                            System.out.println(">>> Delete Recent : Recent data is deleted\n");
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                    break;
                case SEARCH_BIGGER:
                    try {
                        Double target = inputManager.inputTarget();
                        calculator.searchBiggerThanTarget(target);
                    } catch (IllegalStateException e) {
                        System.out.printf("Error: %s\n\n", e.getMessage());
                    }
                    break;
                case SEARCH_SMALLER:
                    try {
                        Double target = inputManager.inputTarget();
                        calculator.searchSmallerThanTarget(target);
                    } catch (IllegalStateException e) {
                        System.out.printf("Error: %s\n\n", e.getMessage());
                    }
                    break;
                case EXIT:
                        System.out.println("Program Terminated");
                        System.exit(0);
                    default:
                        System.out.println("Error occurred. Please try again.");
                }

        }
    }
}