package edu.itu.cavabunga.caldav.entity;

import edu.itu.cavabunga.caldav.entity.component.ComponentType;

@org.springframework.stereotype.Component
public class ComponentFactory {

    public Component createComponent(ComponentType componentType) {
        return componentType.create();
    }
}
