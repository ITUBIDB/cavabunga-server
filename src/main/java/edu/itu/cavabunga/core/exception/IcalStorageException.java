package edu.itu.cavabunga.core.exception;

public class IcalStorageException extends RuntimeException{
    public IcalStorageException(){

    }

    public IcalStorageException(String message){
        super(message);
    }

    public IcalStorageException(Throwable cause){
        super(cause);
    }

    public IcalStorageException(String message, Throwable cause){
        super(message,cause);
    }
}
