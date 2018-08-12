package tr.edu.itu.cavabunga.server.exception;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException(){}
    public AuthenticationException(String message){
        super(message);
    }
    public AuthenticationException(Throwable cause){
        super(cause);
    }
}
