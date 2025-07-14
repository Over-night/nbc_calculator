package interfaces;

import utils.InputtedModification;

import java.util.ArrayList;

public interface Calculator<T> {
    T calculate(InputtedModification<T> modification);
    T getFirstResult();
    T getLastResult();
    ArrayList<T> getAllResults();
    void deleteFirstResult();
    void deleteLastResult();
    void deleteAllResults();
}
