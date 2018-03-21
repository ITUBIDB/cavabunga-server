package edu.itu.cavabunga.core.http;

import edu.itu.cavabunga.core.entity.ComponentProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ComponentPropertyResponse extends Response {

    private List<ComponentProperty> data = new ArrayList <>();

    public ComponentPropertyResponse(Integer code, String message, List<ComponentProperty> data) {
        super(code, message);
        this.data = data;
    }

    public ComponentPropertyResponse(Integer code, String message, ComponentProperty data) {
        super(code, message);
        this.data.add(data);
    }
}
