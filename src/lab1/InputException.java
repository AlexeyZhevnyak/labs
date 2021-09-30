package lab1;

import java.io.FileNotFoundException;

public class InputException extends RuntimeException {
    public InputException(FileNotFoundException e) {
        super(e);
    }
}
