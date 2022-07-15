package com.school.student.exception;

public class ConflitException extends RuntimeException{
    private static final long serialVersionUDI=1l;

    public ConflitException(String message) {
        super(message);
    }
}
