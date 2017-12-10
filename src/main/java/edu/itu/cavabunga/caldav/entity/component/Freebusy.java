package edu.itu.cavabunga.caldav.entity.component;

import edu.itu.cavabunga.caldav.entity.Component;

import javax.persistence.Entity;

@Entity
public class Freebusy extends Component {
    public Freebusy(){
        this.setComponentType(ComponentType.FREEBUSY.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
