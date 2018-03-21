package edu.itu.cavabunga.core.http;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Response {
    private Integer code = 0;
    private String message;

    public Response() {

    }
    public Response(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
