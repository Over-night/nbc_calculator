import interfaces.Calculator;
import interfaces.InputManager;
import utils.InputtedModification;
import v3.CalculatorV3;
import v3.InputManagerV3;


// V3
public class Main {

    public static void main(String[] args) {
        InputManager<Double> inputManager = new InputManagerV3();
        Calculator<Double> calculator = new CalculatorV3();

        while (true) {
            int menu = inputManager.inputMenu();

            switch (menu) {
                    case 1:
                        InputtedModification<Double> modification = inputManager.inputModification();
                        System.out.printf("%f %c %f = %f\n\n",
                                modification.firstOperand(),
                                modification.operator().getFlag(),
                                modification.secondOperand(),
                                calculator.calculate(modification));
                        break;
                    case 2:
                        try {
                            System.out.println("All result: " + calculator.getAllResults());
                            System.out.println();
                        } catch(IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.printf("First result: %f\n\n", calculator.getFirstResult());
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                    break;
                    case 4:
                        try {
                            System.out.printf("Recent result: %f\n\n", calculator.getLastResult());
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            calculator.deleteAllResults();
                            System.out.println("All data is deleted\n");
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            calculator.deleteFirstResult();
                            System.out.println("First data is deleted\n");
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                    case 7:
                        try {
                            calculator.deleteLastResult();
                            System.out.println("Recent data is deleted\n");
                        } catch (IllegalStateException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                    break;
                    case 0:
                        System.out.println("Program Terminated");
                        System.exit(0);
                    default:
                        System.out.println("Error occurred. Please try again.");
                }

        }
    }
}