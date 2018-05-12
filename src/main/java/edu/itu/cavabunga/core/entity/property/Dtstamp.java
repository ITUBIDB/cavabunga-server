package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Dtstamp extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim() == "" ){
            throw new Validation("DTSTAMP property cannot be empty");
        }

        if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("DTSTAMP parameter validation failed: " + this.getValue());
                }
            }
        }
    }
}
