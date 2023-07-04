package com.example.testjpa.exception;

public class EchoServiceException extends RuntimeException{
    public EchoServiceException(){};

    public EchoServiceException(String msg){
        super(msg);
    };
}
