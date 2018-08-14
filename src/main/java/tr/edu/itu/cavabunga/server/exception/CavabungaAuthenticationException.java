package tr.edu.itu.cavabunga.server.exception;

public class CavabungaAuthenticationException extends RuntimeException{
    public CavabungaAuthenticationException(){}
    public CavabungaAuthenticationException(String message){
        super(message);
    }
    public CavabungaAuthenticationException(Throwable cause){
        super(cause);
    }
}
