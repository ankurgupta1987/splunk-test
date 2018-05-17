package com.splunk.exercise.exceptions;

public class NullResponseException extends RuntimeException {

    public NullResponseException(){

    }

    public NullResponseException(String message){
        super(message);
    }
}
