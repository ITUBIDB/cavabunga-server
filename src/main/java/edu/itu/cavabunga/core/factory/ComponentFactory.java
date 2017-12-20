package edu.itu.cavabunga.core.factory;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.exception.IcalStorageException;

import java.util.Date;

@org.springframework.stereotype.Component
public class ComponentFactory {

    public Component createComponent(ComponentType componentType) throws IcalStorageException {
        Component result;
        switch (componentType){
            case CALENDAR:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            case TODO:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            case ALARM:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            case EVENT:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            case JOURNAL:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            case DAYLIGHT:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            case FREEBUSY:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            case STANDARD:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            case TIMEZONE:
                result = componentType.create();
                result.setCreationDate(new Date());
                result.setComponentType(componentType.toString());
                return result;

            default:
                throw new IcalStorageException("Undefined component type tried to create by factory : " + componentType.toString());
        }



    }
}
