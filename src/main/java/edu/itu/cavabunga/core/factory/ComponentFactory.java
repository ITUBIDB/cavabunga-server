package edu.itu.cavabunga.core.factory;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.exception.IcalStorageException;

import java.util.Date;

@org.springframework.stereotype.Component
public class ComponentFactory {

    public Component createComponent(ComponentType componentType) throws IcalStorageException {
        Component result;
        result = componentType.create();
        if(result == null) {
            throw new IcalStorageException("Undefined component type tried to create by factory : " + componentType.toString());
        }

        result.setCreationDate(new Date());
        result.setComponentType(componentType.toString());
        return result;
    }
}
