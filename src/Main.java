import utils.BooleanWithMessage;
import utils.ComputationalData;
import v2.Calculator;
import v2.InputManager;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        Calculator calculator = new Calculator();

        boolean trigger = true;

        do {
            BooleanWithMessage menu = inputManager.inputMenu();

            if (!menu.isValid) {
                System.out.println("Program Terminated");
                trigger = false;
            }

            else {
                switch (menu.message) {
                    case "inputData":
                        ComputationalData data = inputManager.inputData();
                        System.out.println("Calculate result: " + calculator.calculate(data));
                        System.out.println();
                        break;
                    case "getResults":
                        System.out.println("All result: " + calculator.getResults());
                        System.out.println();
                        break;
                    case "getResult":
                        System.out.println("Recent result: " + calculator.getResult());
                        System.out.println();
                        break;
                    case "deleteResults":
                        calculator.deleteResults();
                        System.out.println("All data is deleted\n");
                        break;
                    case "deleteResult":
                        calculator.deleteResult();
                        System.out.println("First data is deleted\n");
                        break;
                    default:
                        System.out.println("Error occurred. Program will be terminated");
                        trigger = false;
                }
            }
        } while (trigger);

        System.out.println("Program Terminated");
    }
}