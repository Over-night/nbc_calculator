package interfaces;

import utils.InputtedModification;

import java.util.ArrayList;

public interface Calculator<T> {
    T calculate(InputtedModification modification);
    T getLastResult();
    ArrayList<T> getAllResults();
    void deleteFirstResult();
    void deleteAllResults();
}
