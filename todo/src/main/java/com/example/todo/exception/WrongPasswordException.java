package com.example.todo.exception;

public class WrongPasswordException extends IllegalArgumentException {
    private String message;
    public WrongPasswordException(String message) {
        this.message = message;
    }
}
