package edu.itu.cavabunga.caldav.entity.component;

import edu.itu.cavabunga.caldav.entity.Component;

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
