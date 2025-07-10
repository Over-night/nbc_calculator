package v2;

import utils.InputtedModification;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Float> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    public Float calculate(InputtedModification data) {
        Float result = switch (data.operator) {
            case '+' -> data.firstOperand + data.secondOperand;
            case '-' -> data.firstOperand - data.secondOperand;
            case '*' -> data.firstOperand * data.secondOperand;
            case '/' -> data.firstOperand / data.secondOperand;
            default -> throw new IllegalArgumentException("Error : Invalid data.");
        };

        results.add(result);

        return result;
    }

    public ArrayList<Float> getAllResults() {
        return results;
    }

    public float getLastResult() {
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
