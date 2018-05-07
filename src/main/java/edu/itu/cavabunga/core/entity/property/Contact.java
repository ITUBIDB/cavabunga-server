package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.Todo;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Contact extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("CONTACT property cannot be empty");
        }

        if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("CONTACT parameter validation failed: " + pr.getValue());
                }
            }
        }
    }
}
