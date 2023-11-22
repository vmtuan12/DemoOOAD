package com.example.todo.controller;

import com.example.todo.exception.NoResultException;
import com.example.todo.exception.WrongPasswordException;
import com.example.todo.http.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllException(Exception e, WebRequest request) {
        return new ErrorResponse(500, e.getLocalizedMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMissingParams(RuntimeException ex) {
        String name = ex.getMessage();
        return new ErrorResponse(400, name);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        return new ErrorResponse(400, name + " parameter is missing");
        // Actual exception handling
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorResponse accessDenied() {
        return new ErrorResponse(403, "no authorization");
    }

    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNoResult(NoResultException ex) {
        String name = ex.getMessage();
        return new ErrorResponse(400, name);
        // Actual exception handling
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNoResult(MissingPathVariableException ex) {
        String name = ex.getVariableName();
        return new ErrorResponse(400, "missing path variable " + name);
        // Actual exception handling
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNoResult(WrongPasswordException ex) {
        String name = ex.getMessage();
        return new ErrorResponse(400, name);
        // Actual exception handling
    }
}
