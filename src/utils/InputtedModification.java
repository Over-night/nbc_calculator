package model;

public class InputtedModification {
    public final double firstOperand;
    public final double secondOperand;
    public final char operator;

    public InputtedModification(double firstOperand, double secondOperand, char operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }
}
