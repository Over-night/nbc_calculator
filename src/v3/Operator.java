package v3;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char label;

    Operator(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }
}
