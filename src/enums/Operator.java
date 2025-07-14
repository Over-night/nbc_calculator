package enums;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char flag;

    Operator(char flag) {
        this.flag = flag;
    }

    public char getFlag() {
        return flag;
    }
}
