package edu.itu.cavabunga.core.exception;

public class ParticipantConflictException extends RuntimeException {
    public ParticipantConflictException(){

    }

    public ParticipantConflictException(String message){
        super(message);
    }

    public ParticipantConflictException(Throwable cause){
        super(cause);
    }

    public ParticipantConflictException(String message, Throwable cause){
        super(message,cause);
    }

}
