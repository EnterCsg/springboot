package com.example.springboot01.exception;

public class ProcessFailException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    protected final String message;

    public ProcessFailException(String message)
    {
        this.message = message;
    }

    public ProcessFailException(String message, Throwable e)
    {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
