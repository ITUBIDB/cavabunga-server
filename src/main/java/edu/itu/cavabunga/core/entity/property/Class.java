package edu.itu.cavabunga.core.entity.property;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.Alarm;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Class extends Property {
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("CLASS property cannot be empty");
        }

        if(this.getValue() != "PUBLIC" &&
                this.getValue() != "PRIVATE" &&
                this.getValue() != "CONFIDENTIAL"){
            throw new Validation("CLASS value is different from acceptable value range: " + this.getValue());
        }

          if(!this.getParameters().isEmpty()){
            for(Parameter pr : this.getParameters()){
                try {
                    pr.validate();
                }catch (Exception e){
                    throw new Validation("CLASS parameter validation failed: " + pr.getValue());
                }
          }
        }
    }
}
