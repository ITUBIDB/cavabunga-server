package edu.itu.cavabunga.entity;

import edu.itu.cavabunga.entity.property.PropertyType;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyFactory {

    public Property createProperty(PropertyType propertyType) {
        return propertyType.create();
    }
}
