package edu.itu.cavabunga.exception;

public class ComponentConflict extends RuntimeException {
    public ComponentConflict(){

    }

    public ComponentConflict(String message){
        super(message);
    }

    public ComponentConflict(Throwable cause){
        super(cause);
    }

}
