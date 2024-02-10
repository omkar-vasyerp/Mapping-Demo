package com.omkar.mappingdemo.exception;

public class StateNotFoundException extends RuntimeException {
    public StateNotFoundException(){

    }
    public StateNotFoundException(String message){
        super(message);
    }

}
