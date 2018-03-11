package edu.itu.cavabunga.exception;

public class ParameterNotFound extends RuntimeException {
    public ParameterNotFound(){

    }

    public ParameterNotFound(String message){
        super(message);
    }

    public ParameterNotFound(Throwable cause){
        super(cause);
    }



}
