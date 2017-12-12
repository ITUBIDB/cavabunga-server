package edu.itu.cavabunga.core.entity.component;

import edu.itu.cavabunga.core.entity.Component;


public class Todo extends Component{
    public Todo(){
        this.setComponentType(ComponentType.TODO.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
