package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Reltype extends Parameter{
    @Override
    public void validate(){
        if(this.getValue().trim() != ""){
            throw new Validation("RELTYPE parameter cannot be empty");
        }

        if(this.getValue() != "PARENT" &&
                this.getValue() != "CHILD" &&
                this.getValue() != "SIBLING"){
            throw new Validation("RELTYPE value is different from acceptable value range: " + this.getValue());
        }
    }
}
