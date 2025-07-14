package v3;

import interfaces.Calculator;
import utils.InputtedModification;
import utils.Result;

import java.util.ArrayList;

public class CalculatorV3 implements Calculator<Result, Double>  {
    private final ArrayList<Result> results;

    public CalculatorV3() {
        results = new ArrayList<>();
    }

    public Result calculate(InputtedModification<Double> modification) {
        double calculate_result = switch (modification.operator()) {
            case PLUS -> modification.firstOperand() + modification.secondOperand();
            case MINUS -> modification.firstOperand() - modification.secondOperand();
            case MULTIPLY -> modification.firstOperand() * modification.secondOperand();
            case DIVIDE -> modification.firstOperand() / modification.secondOperand();
            default -> throw new IllegalArgumentException("Error : Invalid modification.");
        };

        Result result = new Result(
                String.format("%f %c %f = %f",
                        modification.firstOperand(),
                        modification.operator().getFlag(),
                        modification.secondOperand(),
                        calculate_result),
                calculate_result
        );

        results.add(result);

        return result;
    }

    public ArrayList<Result> getAllResults() {
        if (results.isEmpty()) throw new IllegalStateException("List is empty.");

        return results;
    }

    public Result getFirstResult() {
        try {
            return results.get(0);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    public Result getLastResult() {
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
