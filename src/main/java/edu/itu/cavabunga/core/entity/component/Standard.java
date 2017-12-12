package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

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
