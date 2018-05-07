package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Fmttype extends Parameter {
    @Override
    public void validate(){
        if(this.getValue().trim() == ""){
            throw new Validation("FMTTYPE cannot be empty");
        }

        if(this.getValue().matches("(\\w+)/(\\w+)") != true){
            throw new Validation("FMTYPE must have valid mime type: " + this.getValue());
        }
    }
}
