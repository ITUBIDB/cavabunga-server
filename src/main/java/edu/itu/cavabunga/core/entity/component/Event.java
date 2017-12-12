package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

import javax.persistence.Entity;

@Entity
public class Event extends Component {
    public Event(){
        this.setComponentType(ComponentType.EVENT.name());
    }

    public boolean validate(){
        return true;
    }
}
