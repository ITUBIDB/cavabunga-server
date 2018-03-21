package edu.itu.cavabunga.core.http;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends Response {

    private Object data;

    public ErrorResponse(Integer code, String message, Object data) {
        super(code, message);
        this.data = data;
    }
}
