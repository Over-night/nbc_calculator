package interfaces;

import utils.InputtedModification;
import utils.Menu;
import v2.InputtedModificationV2;

public interface InputManager<T> {
    Menu inputMenu();
    InputtedModification<T> inputModification();
}
