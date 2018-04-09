package edu.itu.cavabunga.core.http;

import lombok.Data;

@Data
public class Response {
    private Integer code;
    private String message;

    public Response(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
