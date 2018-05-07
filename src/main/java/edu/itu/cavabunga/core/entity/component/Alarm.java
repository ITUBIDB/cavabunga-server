package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Alarm extends Component{
    @Override
    public void validate(){
        if(!this.getProperties().isEmpty()){
            for(Property p : this.getProperties()){
                try{
                    p.validate();
                }catch (Exception e){
                    throw new Validation("Alarm property validation failed: " + p.getValue());
                }
            }
        }

        if(!this.getComponents().isEmpty()){
            throw new Validation("Alarm component cannot have sub-component");
        }
    }
}
