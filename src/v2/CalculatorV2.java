package v2;

import interfaces.Calculator;
import utils.InputtedModification;

import java.util.ArrayList;

public class CalculatorV2 implements Calculator<Double>  {
    private final ArrayList<Double> results;

    public CalculatorV2() {
        results = new ArrayList<>();
    }

    public Double calculate(InputtedModification data) {
        double result = switch (data.operator) {
            case '+' -> data.firstOperand + data.secondOperand;
            case '-' -> data.firstOperand - data.secondOperand;
            case '*' -> data.firstOperand * data.secondOperand;
            case '/' -> data.firstOperand / data.secondOperand;
            default -> throw new IllegalArgumentException("Error : Invalid data.");
        };

        results.add(result);

        return result;
    }

    public ArrayList<Double> getAllResults() {
        return results;
    }

    public Double getLastResult() {
        try {
            return results.get(results.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    public void deleteFirstResult() {
        try {
            results.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("List is empty.");
        }

        System.out.println("Deleted first result");
    }

    public void deleteAllResults() {
        results.clear();

        System.out.println("Deleted all of results");
    }
}
