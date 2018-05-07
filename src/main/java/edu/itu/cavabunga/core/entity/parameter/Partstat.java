package edu.itu.cavabunga.core.entity.parameter;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Partstat extends Parameter {
    @Override
    public void validate(){
        if(this.getValue().trim() == ""){
            throw new Validation("PARTSTAT value cannot be empty");
        }

        if(this.getValue() != "NEEDS-ACTION" &&
                this.getValue() != "ACCEPTED" &&
                this.getValue() != "DECLINED" &&
                this.getValue() != "TENTATIVE" &&
                this.getValue() != "DELEGATED" &&
                this.getValue() != "COMPLETED" &&
                this.getValue() != "IN-PROCESS"){
            throw new Validation("PARTSTAT value is different from acceptable value range: " + this.getValue());
        }
        // TODO: value of partstat may depend on component type which this parameter's property have used in
        //       check RFC 5545
    }
}
