package edu.itu.cavabunga.core.http;

import edu.itu.cavabunga.core.entity.Property;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PropertyResponse extends Response {

    private List<Property> data = new ArrayList <>();

    public PropertyResponse(Integer code, String message, List<Property> data) {
        super(code, message);
        this.data = data;
    }

    public PropertyResponse(Integer code, String message, Property data) {
        super(code, message);
        this.data.add(data);
    }
}
