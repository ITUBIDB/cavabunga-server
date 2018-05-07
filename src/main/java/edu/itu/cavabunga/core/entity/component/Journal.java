package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.property.Dtstamp;
import edu.itu.cavabunga.core.entity.property.Uid;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Journal extends Component {
    @Override
    public void validate(){
        //TODO: linear search
        boolean isDtstampExists = false;
        boolean isUidExists = false;
        if(!this.getProperties().isEmpty()){
            for(Property p : this.getProperties()){
                if(p instanceof Dtstamp){
                    isDtstampExists = true;
                }

                if(p instanceof Uid){
                    isUidExists = true;
                }

                try{
                    p.validate();
                }catch (Exception e){
                    throw new Validation("Journal component property validation failed: " + p.getValue());
                }
            }

            if(!(isDtstampExists && isUidExists)){
                throw new Validation("Journal component must have DTSTAMP and UID properties");
            }
        }

        if(!this.getComponents().isEmpty()){
            throw new Validation("Journal component cannot have sub-components");
        }

    }
}
