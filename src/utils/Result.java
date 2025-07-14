package utils;

public record Result(String modification, double value) {
    @Override
    public String toString() {
        return String.format("%-15f | %s",value, modification);
    }
}
