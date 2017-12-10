package edu.itu.cavabunga.caldav.entity.component;

import edu.itu.cavabunga.caldav.entity.Component;

import javax.persistence.Entity;

@Entity
public class Journal extends Component {
    public Journal(){
        this.setComponentType(ComponentType.JOURNAL.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
