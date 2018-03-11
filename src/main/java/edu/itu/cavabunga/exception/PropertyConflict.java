package edu.itu.cavabunga.exception;

public class PropertyConflict extends RuntimeException {
    public PropertyConflict(){

    }

    public PropertyConflict(String message){
        super(message);
    }

    public PropertyConflict(Throwable cause){
        super(cause);
    }

}
