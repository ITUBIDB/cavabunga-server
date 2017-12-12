package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

import javax.persistence.Entity;

@Entity
public class Daylight extends Component{
    public Daylight(){
        this.setComponentType(ComponentType.DAYLIGHT.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
