package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;

import javax.persistence.Entity;

@Entity
public class Timezone extends Component {
    public Timezone(){
        this.setComponentType(ComponentType.TIMEZONE.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
