package ru.labs.lab1.errors;

public class MatrixException extends RuntimeException {
    private static final String MATRIX = "MATRIX EXCEPTION: ";
    private static final long serialVersionUID = -4746563674615473478L;

    public MatrixException(String message) {
        super(MATRIX + message);
    }
}
