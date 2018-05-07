package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.property.Prodid;
import edu.itu.cavabunga.core.entity.property.Version;
import edu.itu.cavabunga.exception.Validation;

import javax.persistence.Entity;

@Entity
public class Calendar extends Component {
    @Override
    public void validate(){
        //TODO: this is a linear search could cause performence problems, take a look 'JAVA 8 Streams'
        if(!this.getProperties().isEmpty()) {
            boolean isProdidExists = false;
            boolean isVersionExists = false;
            for (Property p : this.getProperties()) {
                if (p instanceof Prodid) {
                    isProdidExists = true;
                }

                if (p instanceof Version) {
                    isVersionExists = true;
                }


                try {
                    p.validate();
                } catch (Exception e){
                    throw new Validation("Property validation failed: " + p.getValue());
                }

            }


            if (!(isProdidExists && isVersionExists)) {
                throw new Validation("CALENDAR object must have PRODID and VERSION properties");
            }
        }

        if(!this.getComponents().isEmpty()) {
            try {
                for (Component c : this.getComponents()){
                    c.validate();
                }
            } catch(Exception e) {
                throw new Validation("Calendar object's sub components caused validation exception");
            }
        }
        //TODO: according to rfc 5545 calendar component should at least one sub-component, but how to create participants first empty calendar??
    }
}
