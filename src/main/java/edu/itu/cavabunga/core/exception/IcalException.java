package edu.itu.cavabunga.core.exception;

public class IcalException extends RuntimeException{
    public IcalException(){

    }

    public IcalException(String message){
        super(message);
    }

    public IcalException(Throwable cause){
        super(cause);
    }

    public IcalException(String message, Throwable cause){
        super(message,cause);
    }
}
