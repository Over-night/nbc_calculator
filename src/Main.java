import interfaces.Calculator;
import interfaces.InputManager;
import model.InputtedModification;
import v2.CalculatorV2;
import v2.InputManagerV2;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    public static void main(String[] args) {
        InputManager inputManager = new InputManagerV2();
        Calculator<Double> calculator = new CalculatorV2();

        while (true) {
            int menu = inputManager.inputMenu();

            switch (menu) {
                    case 1:
                        InputtedModification modification = inputManager.inputModification();
                        System.out.printf("%f %c %f = %f\n\n",
                                modification.firstOperand,
                                modification.operator,
                                modification.secondOperand,
                                calculator.calculate(modification));
                        break;
                    case 2:
                        System.out.println("All result: " + calculator.getAllResults());
                        System.out.println();
                        break;
                    case 3:
                        try {
                            System.out.printf("Recent result: %f\n\n", calculator.getLastResult());
                        } catch (IndexOutOfBoundsException e) {
                            System.out.printf("Error: %s\n\n", e.getMessage());
                        }
                        break;
                    case 4:
                        calculator.deleteAllResults();
                        System.out.println("All data is deleted\n");
                        break;
                    case 5:
                        try {
                            calculator.deleteFirstResult();
                            System.out.println("First data is deleted\n");
                        } catch (IndexOutOfBoundsException e) {
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