package com.example.todo.exception;

public class NoResultException extends NullPointerException {

    private String message;

    public NoResultException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
