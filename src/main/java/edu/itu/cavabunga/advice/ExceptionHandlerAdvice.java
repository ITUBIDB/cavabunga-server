package edu.itu.cavabunga.advice;

import edu.itu.cavabunga.controller.response.ErrorResponse;
import edu.itu.cavabunga.exception.Conflict;
import edu.itu.cavabunga.exception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleParticipantNotFound(NotFound e){
        return new ErrorResponse(1,e.getMessage(), null);
    }

    @ExceptionHandler(Conflict.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleParticipantConflict(Conflict e){
        return new ErrorResponse(1,e.getMessage(),null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e){
        return new ErrorResponse(1,e.getMessage(), null);
    }


}
