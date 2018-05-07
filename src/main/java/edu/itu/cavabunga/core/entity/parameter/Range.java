package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;
import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.persistence.Entity;

@Entity
public class Range extends Parameter {
    @Override
    public void validate(){
        if(this.getValue().trim() == ""){
            throw new Validation("RANGE parameter cannot be empty");
        }

        if(this.getValue() != "THISANDFUTURE"){
            throw new Validation("RANGE parameter can only have THISANDFUTURE value: " + this.getValue());
        }
    }
}
