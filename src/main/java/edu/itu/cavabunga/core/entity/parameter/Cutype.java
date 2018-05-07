package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Cutype extends Parameter {
    @Override
    public void validate(){
        if(this.getValue().trim() == ""){
            throw new Validation("CUTYPE value cannot be empty");
        }

        if(this.getValue() != "INDIVIDUAL" &&
                this.getValue() != "GROUP" &&
                this.getValue() != "RESOURCE" &&
                this.getValue() != "ROOM" &&
                this.getValue() != "UNKNOWN"){
            throw new Validation("CUTYPE value is different from acceptable value range: " + this.getValue());
        }

    }
}
