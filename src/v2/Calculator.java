package v2;

import utils.ComputationalData;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Float> results;

    public Calculator() {
        results = new ArrayList<>();
    }

    public Float calculate(ComputationalData data) {
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

    public ArrayList<Float> getResults() {
        return results;
    }

    public float getResult() {
        return results.get(results.size() - 1);
    }

    public void deleteResult() {
        try {
            results.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Error : List is empty.");
        }

        System.out.println("Deleted first result");
    }

    public void deleteResults() {
        results.clear();

        System.out.println("Deleted all of results");
    }
}
