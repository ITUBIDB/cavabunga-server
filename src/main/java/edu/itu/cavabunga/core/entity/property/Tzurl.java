package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Property;

import javax.persistence.Entity;

@Entity
public class Tzurl extends Property {
    @Override
    public void validate(){
        super.validate();
        super.validateValueType(PropertyValueType.URI);
    }
}
