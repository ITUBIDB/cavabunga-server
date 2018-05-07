package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Language extends Parameter {
    @Override
    public void validate(){
       if(this.getValue().trim() != ""){
           throw new Validation("LANGUAGE parameter cannot be empty");
       }

        // TODO: Look for language expression types
        //       for example us or us-EN
    }
}
