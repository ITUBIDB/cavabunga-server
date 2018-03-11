package edu.itu.cavabunga.exception;

public class ParticipantNotFound extends RuntimeException {
    public ParticipantNotFound(){

    }

    public ParticipantNotFound(String message){
        super(message);
    }

    public ParticipantNotFound(Throwable cause){
        super(cause);
    }


}
