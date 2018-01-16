package edu.itu.cavabunga.core.factory;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.exception.IcalStorageException;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class ComponentFactory {

    public Component createComponent(ComponentType componentType) throws IcalStorageException {
        Component result = componentType.create();
        if(result == null) {
            throw new IcalStorageException("Undefined component type tried to create by factory : " + componentType.toString());
        }
        return result;
    }
}
