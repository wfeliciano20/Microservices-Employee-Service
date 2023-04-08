package com.williamfeliciano.employeeservice.Exception;

public class EmailAlreadyExistException extends RuntimeException{
    private String Message;
    public EmailAlreadyExistException(String message) {
        super(message);
        Message = message;
    }
}
