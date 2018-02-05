package edu.itu.cavabunga.core.exception;

public class IcalNotFound extends RuntimeException{
    public IcalNotFound(){

    }

    public IcalNotFound(String message){
        super(message);
    }

    public IcalNotFound(Throwable cause){
        super(cause);
    }

    public IcalNotFound(String message, Throwable cause){
        super(message,cause);
    }
}
