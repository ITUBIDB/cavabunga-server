package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.Alarm;
import edu.itu.cavabunga.core.entity.component.Event;
import edu.itu.cavabunga.core.entity.component.Journal;
import edu.itu.cavabunga.core.entity.component.Todo;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;
import java.util.concurrent.ExecutionException;

@Entity
public class Description extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("DESCRIPTION property cannot be empty");
        }

        if (!(this.getComponent() instanceof Event ||
                this.getComponent() instanceof Todo ||
                this.getComponent() instanceof Journal ||
                this.getComponent() instanceof Alarm)){
            throw new Validation("DESCRIPTION property can only use in Event, Todo, Journal or Alarm components");
        }

        if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("DESCRIPTION parameter validation failed: " + this.getValue());
                }
            }
        }
    }
}
