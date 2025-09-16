package com.tapan.exception;


public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message)
    {
        super(message);
    }
    public DataNotFoundException()
    {
        super("Data Not Found On Server");
    }
}
