package com.tapan.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super("Data Not Found On Server");
    }
    public DataNotFoundException(String s)
    {
        super(s);
    }
}
