package edu.itu.cavabunga.core.exception;

public class ParticipantNotFound extends RuntimeException {
    public ParticipantNotFound(){

    }

    public ParticipantNotFound(String message){
        super(message);
    }

    public ParticipantNotFound(Throwable cause){
        super(cause);
    }

    public ParticipantNotFound(String message, Throwable cause){
        super(message,cause);
    }

}
