package edu.itu.cavabunga.core.exception;

public class IcalNotFoundException extends RuntimeException{
    public IcalNotFoundException(){

    }

    public IcalNotFoundException(String message){
        super(message);
    }

    public IcalNotFoundException(Throwable cause){
        super(cause);
    }

    public IcalNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
