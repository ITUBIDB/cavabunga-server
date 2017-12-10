package edu.itu.cavabunga.caldav.entity.component;

import edu.itu.cavabunga.caldav.entity.Component;


public class Todo extends Component{
    public Todo(){
        this.setComponentType(ComponentType.TODO.name());
    }

    @Override
    public boolean validate(){
        return true;
    }
}
