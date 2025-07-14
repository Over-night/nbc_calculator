package interfaces;

import utils.InputtedModification;
import v2.InputtedModificationV2;

public interface InputManager<T> {
    int inputMenu();
    InputtedModification<T> inputModification();
}
