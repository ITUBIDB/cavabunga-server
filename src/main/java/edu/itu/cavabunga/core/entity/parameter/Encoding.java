package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Encoding extends Parameter {
    @Override
    public void validate(){
        if(this.getValue().trim() == ""){
            throw new Validation("ENCODING value cannot be empty");
        }

        if(this.getValue() != "BASE64" && this.getValue() != "8BIT"){
            throw new Validation("ENCODING value is different from acceptable value range: " + this.getValue());
        }

    }
}
