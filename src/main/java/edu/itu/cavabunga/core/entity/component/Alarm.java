package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

import javax.persistence.Entity;

@Entity
public class Alarm extends Component{
    public Alarm(){
        this.setComponentType(ComponentType.ALARM.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
