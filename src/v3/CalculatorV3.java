package v3;

import interfaces.Calculator;
import model.InputtedModification;
import model.Result;

import java.util.ArrayList;

public class CalculatorV3 implements Calculator<Result, Double>  {
    private final ArrayList<Result> results;

    public CalculatorV3() {
        results = new ArrayList<>();
    }

    // 계산 함수
    @Override
    public Result calculate(InputtedModification<Double> modification) {
        double calculate_result = switch (modification.operator()) {
            case PLUS -> modification.firstOperand() + modification.secondOperand();
            case MINUS -> modification.firstOperand() - modification.secondOperand();
            case MULTIPLY -> modification.firstOperand() * modification.secondOperand();
            case DIVIDE -> modification.firstOperand() / modification.secondOperand();
            default -> throw new IllegalArgumentException("Error : Invalid modification.");
        };

        // 반환값 : 수식(String), 결과값(Double)
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


    // 전체 결과 조회
    @Override
    public ArrayList<Result> getAllResults() {
        if (results.isEmpty()) throw new IllegalStateException("List is empty.");

        return results;
    }

    // 첫 결과 조회
    @Override
    public Result getFirstResult() {
        try {
            return results.get(0);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    // 최근 결과 조회
    @Override
    public Result getLastResult() {
        try {
            return results.get(results.size() - 1);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    // 첫 결과 삭제
    @Override
    public void deleteFirstResult() {
        try {
            results.remove(0);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is already empty.");
        }

        System.out.println("Deleted first result");
    }

    // 최근 결과 삭제
    @Override
    public void deleteLastResult() {
        try {
            results.remove(results.size() - 1);
        } catch (IllegalStateException e) {
            throw new IndexOutOfBoundsException("List is already empty.");
        }

        System.out.println("Deleted last result");
    }

    // 전체 결과 삭제
    @Override
    public void deleteAllResults() {
        if(results.isEmpty()) throw new IllegalStateException("List is already empty.");

        results.clear();
        System.out.println("Deleted all of results");
    }

    // 입력값 보다 큰 결과로 필터링
    @Override
    public void searchBiggerThanTarget(Double target) {
        if(results.isEmpty()) throw new IllegalStateException("List is empty.");

        System.out.printf(">>> Result that bigger than %f: \n", target);
        results.stream()
                .filter(x -> x.value() > target)
                .forEach(System.out::println);
        System.out.println();
    }

    // 입력값 보다 작은 결과로 필터링
    @Override
    public void searchSmallerThanTarget(Double target) {
        if(results.isEmpty()) throw new IllegalStateException("List is empty.");

        System.out.printf(">>> Result that smaller than %f: \n", target);
        results.stream()
                .filter(x -> x.value() < target)
                .forEach(System.out::println);
        System.out.println();
    }
}
