package v3;

import interfaces.Calculator;
import utils.InputtedModification;

import java.util.ArrayList;

public class CalculatorV3 implements Calculator<Double>  {
    private final ArrayList<Double> results;

    public CalculatorV3() {
        results = new ArrayList<>();
    }

    public Double calculate(InputtedModification<Double> modification) {
        double result = switch (modification.operator()) {
            case PLUS -> modification.firstOperand() + modification.secondOperand();
            case MINUS -> modification.firstOperand() - modification.secondOperand();
            case MULTIPLY -> modification.firstOperand() * modification.secondOperand();
            case DIVIDE -> modification.firstOperand() / modification.secondOperand();
            default -> throw new IllegalArgumentException("Error : Invalid modification.");
        };

        results.add(result);

        return result;
    }

    public ArrayList<Double> getAllResults() {
        if (results.isEmpty()) throw new IllegalStateException("List is empty.");

        return results;
    }

    public Double getFirstResult() {
        try {
            return results.get(0);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    public Double getLastResult() {
        try {
            return results.get(results.size() - 1);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    public void deleteFirstResult() {
        try {
            results.remove(0);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is already empty.");
        }

        System.out.println("Deleted first result");
    }

    public void deleteLastResult() {
        try {
            results.remove(results.size() - 1);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is already empty.");
        }

        System.out.println("Deleted last result");
    }

    public void deleteAllResults() {
        if(results.isEmpty()) throw new IllegalStateException("List is already empty.");

        results.clear();
        System.out.println("Deleted all of results");
    }
}
