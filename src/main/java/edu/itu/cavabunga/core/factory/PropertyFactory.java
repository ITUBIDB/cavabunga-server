package edu.itu.cavabunga.core.factory;

import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.property.PropertyType;
import org.springframework.stereotype.Component;

@Component
public class PropertyFactory {

    public Property createProperty(PropertyType propertyType) {
        return propertyType.create();
    }
}