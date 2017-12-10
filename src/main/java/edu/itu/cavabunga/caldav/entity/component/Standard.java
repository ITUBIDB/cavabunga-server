package edu.itu.cavabunga.caldav.entity.component;

import edu.itu.cavabunga.caldav.entity.Component;

import javax.persistence.Entity;

@Entity
public class Standard extends Component {
    public Standard(){
        this.setComponentType(ComponentType.STANDARD.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
