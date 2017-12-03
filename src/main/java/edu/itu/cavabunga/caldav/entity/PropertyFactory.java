package edu.itu.cavabunga.caldav.entity;

import edu.itu.cavabunga.caldav.entity.property.PropertyType;
import org.springframework.stereotype.Component;

@Component
public class PropertyFactory {

    public Property createProperty(PropertyType propertyType) {
        return propertyType.create();
    }
}
