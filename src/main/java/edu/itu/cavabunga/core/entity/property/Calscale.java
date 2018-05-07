package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.Alarm;
import edu.itu.cavabunga.core.entity.component.Calendar;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Calscale extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("CALSCALE property cannot be empty");
        }

        //TODO: is cavabunga support only for Gregorian calendar?
        if(this.getValue() != "GREGORIAN" ){
            throw new Validation("CALSCALE value is different from acceptable value range: " + this.getValue());
        }

        if(!(this.getComponent() instanceof Calendar)){
            throw new Validation("CALSCALE property can only be use in Calendar component");
        }

        if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("CALENDAR parameter validation failed: " + pr.getValue());
                }
            }
        }
    }
}
