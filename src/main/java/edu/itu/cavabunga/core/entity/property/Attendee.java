package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.Alarm;
import edu.itu.cavabunga.core.entity.component.Freebusy;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Attendee extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("ATTENDEE property cannot be empty");
        }


        if((this.getComponent() instanceof Alarm) || (this.getComponent() instanceof Freebusy) ){
            throw new Validation("ATTENDEE property cannot use in Alarm or Freebusy component");
        }

        if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("ATTENDEE parameter validation failed: " + pr.getValue());
                }
            }
        }
    }

}
