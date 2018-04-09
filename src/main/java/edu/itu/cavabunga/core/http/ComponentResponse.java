package edu.itu.cavabunga.core.http;

import edu.itu.cavabunga.core.entity.Component;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ComponentResponse extends Response {

    private List<Component> data = new ArrayList <>();

    public ComponentResponse(Integer code, String message, List<Component> data) {
        super(code, message);
        this.data = data;
    }

    public ComponentResponse(Integer code, String message, Component data) {
        super(code, message);
        this.data.add(data);
    }
}
