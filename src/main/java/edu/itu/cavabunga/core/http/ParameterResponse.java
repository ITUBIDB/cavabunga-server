package edu.itu.cavabunga.core.http;

import edu.itu.cavabunga.core.entity.Parameter;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ParameterResponse extends Response {

    private List<Parameter> data = new ArrayList <>();

    public ParameterResponse(Integer code, String message, List<Parameter> data) {
        super(code, message);
        this.data = data;
    }

    public ParameterResponse(Integer code, String message, Parameter data) {
        super(code, message);
        this.data.add(data);
    }
}
