package model;

import enums.Operator;

public record InputtedModification<T>(T firstOperand, T secondOperand, Operator operator) { }
