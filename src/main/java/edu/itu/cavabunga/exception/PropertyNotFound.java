package edu.itu.cavabunga.exception;

public class PropertyNotFound extends RuntimeException {
    public PropertyNotFound(){

    }

    public PropertyNotFound(String message){
        super(message);
    }

    public PropertyNotFound(Throwable cause){
        super(cause);
    }


}
