package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.property.Tzid;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Timezone extends Component {
    @Override
    public void validate(){
        boolean isTzidExists = false;
        if(!this.getProperties().isEmpty()){
            for(Property p : this.getProperties()){
                if(p instanceof Tzid){
                    isTzidExists = true;
                }

                try {
                    p.validate();
                }catch (Exception e){
                    throw new Validation("Timezone property validation failed: " + p.getValue());
                }
            }

            if(!isTzidExists){
                throw new Validation("Timezone component must have TZID component");
            }
        }

        if(!this.getComponents().isEmpty()){
            throw new Validation("Timezone component cannot have sub-component");
        }
    }
}
