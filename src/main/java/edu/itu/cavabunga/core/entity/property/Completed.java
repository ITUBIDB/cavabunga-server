package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.Alarm;
import edu.itu.cavabunga.core.entity.component.Todo;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Completed extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("COMPLETED property cannot be empty");
        }

        if(!(this.getComponent() instanceof Todo)){
            throw new Validation("COMPLETED property can only be use in Todo component");
        }

        if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("COMPLETED parameter validation failed: " + pr.getValue());
                }
            }
        }
    }
}
