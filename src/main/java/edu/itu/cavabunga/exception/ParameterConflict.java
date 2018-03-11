package edu.itu.cavabunga.exception;

public class ParameterConflict extends RuntimeException {
    public ParameterConflict(){

    }

    public ParameterConflict(String message){
        super(message);
    }

    public ParameterConflict(Throwable cause){
        super(cause);
    }


}
