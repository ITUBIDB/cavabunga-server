package edu.itu.cavabunga.core.exception;

public class ParticipantNotFoundException extends RuntimeException {
    public ParticipantNotFoundException(){

    }

    public ParticipantNotFoundException(String message){
        super(message);
    }

    public ParticipantNotFoundException(Throwable cause){
        super(cause);
    }

    public ParticipantNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

}
