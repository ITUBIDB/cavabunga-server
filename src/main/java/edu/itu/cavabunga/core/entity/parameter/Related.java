package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Related extends Parameter {
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("RELATED parameter cannot be empty");
        }

        if(this.getValue() != "START" && this.getValue() != "END"){
            throw new Validation("RELATED value is different from acceptable value range: " + this.getValue());
        }
    }
}
