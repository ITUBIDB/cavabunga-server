package edu.itu.cavabunga.exception;

public class ComponentNotFound extends RuntimeException{
    public ComponentNotFound(){

    }

    public ComponentNotFound(String message){
        super(message);
    }

    public ComponentNotFound(Throwable cause){
        super(cause);
    }

    public ComponentNotFound(String message, Throwable cause){
        super(message,cause);
    }
}
