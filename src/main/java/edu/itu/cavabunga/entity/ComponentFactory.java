package edu.itu.cavabunga.entity;

import edu.itu.cavabunga.entity.component.ComponentType;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentFactory {

    public Component createComponent(ComponentType componentType) {
        return componentType.create();
    }
}
