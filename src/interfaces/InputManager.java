package interfaces;

import model.InputtedModification;
import enums.Menu;

public interface InputManager<T> {
    Menu inputMenu();
    InputtedModification<T> inputModification();
    T inputTarget();
}
