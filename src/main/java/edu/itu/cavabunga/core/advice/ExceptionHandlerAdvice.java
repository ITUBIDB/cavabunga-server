package edu.itu.cavabunga.core.advice;

import edu.itu.cavabunga.core.controller.wrapper.ErrorResponse;
import edu.itu.cavabunga.core.exception.IcalNotFound;
import edu.itu.cavabunga.core.exception.ParticipantConflict;
import edu.itu.cavabunga.core.exception.ParticipantNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(IcalNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleIcalNotFound(IcalNotFound e){
        return new ErrorResponse(1,e.getMessage(), null);
    }

    @ExceptionHandler(ParticipantNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleParticipantNotFound(ParticipantNotFound e){
        return new ErrorResponse(1,e.getMessage(), null);
    }

    @ExceptionHandler(ParticipantConflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleParticipantConflict(ParticipantConflict e){
        return new ErrorResponse(1,e.getMessage(),null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e){
        return new ErrorResponse(1,e.getMessage(), null);
    }


}
