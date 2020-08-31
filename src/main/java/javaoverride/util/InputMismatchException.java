package javaoverride.util;

import javaoverride.util.NoSuchElementException;

public class InputMismatchException extends NoSuchElementException {
    public InputMismatchException() {
    }

    public InputMismatchException(String message) {
        super(message);
    }
}
