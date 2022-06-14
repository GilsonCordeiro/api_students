package com.school.student.exception;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUDI=1l;

    public NotFoundException(String message) {
        super(message);
    }
}
