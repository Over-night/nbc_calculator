package interfaces;

import utils.InputtedModification;

import java.util.ArrayList;

public interface Calculator<R,T> {
    R calculate(InputtedModification<T> modification);
    R getFirstResult();
    R getLastResult();
    ArrayList<R> getAllResults();
    void deleteFirstResult();
    void deleteLastResult();
    void deleteAllResults();
}
