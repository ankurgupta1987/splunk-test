package com.splunk.exercise.exceptions;

public class BaseException  extends Exception{

    public BaseException(String message, Exception ex){
        super(message, ex);
    }
}
