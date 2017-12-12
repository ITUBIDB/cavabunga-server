package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

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
