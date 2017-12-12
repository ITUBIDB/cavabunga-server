package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

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
