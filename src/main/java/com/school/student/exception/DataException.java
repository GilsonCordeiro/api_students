package com.school.student.exception;

public class DataException extends RuntimeException{
    private static final long serialVersionUDI=1l;

    public DataException(String message) {
        super(message);
    }
}
