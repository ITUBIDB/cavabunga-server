package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Cn extends Parameter {
    @Override
    public void validate(){
        if(this.getValue().trim() == ""){
            throw new Validation("CN parameter cannot be empty");
        }

        if(this.getValue().substring(0,1) != "\"" || this.getValue().substring(this.getValue().length() -1) != "\""){
            throw new Validation("CN parameter must start and end with DQUOTE char.");
        }

    }
}
