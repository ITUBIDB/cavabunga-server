package tr.edu.itu.cavabunga.server.exception;

public class CavabungaAuthorizationException extends RuntimeException {
    public CavabungaAuthorizationException(){}
    public CavabungaAuthorizationException(String message){
        super(message);
    }
    public CavabungaAuthorizationException(Throwable cause){
        super(cause);
    }
}
