package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.Alarm;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Action extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("ACTION property cannot be empty");
        }

        if(this.getValue() != "AUDIO" &&
                this.getValue() != "DISPLAY" &&
                this.getValue() != "EMAIL"){
            throw new Validation("ACTION value is different from acceptable value range: " + this.getValue());
        }

        if(!(this.getComponent() instanceof Alarm)){
            throw new Validation("ACTION property can only be use in Alarm component");
        }

        if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("ACTION parameter validation failed: " + pr.getValue());
                }
            }
        }
    }
}
