package edu.itu.cavabunga.core.services;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.parameter.ParameterType;
import edu.itu.cavabunga.core.entity.property.PropertyType;

import java.util.Optional;

public interface IcalService {
    Component createComponent(ComponentType componentType);

    Component createComponentForParticipant(ComponentType componentType, Participant participant);

    Optional<Component> getComponentById(Long id);

    void saveComponent(Component component);

    void deleteComponentById(Long id);

    Property createProperty(PropertyType propertyType);

    Optional<Property>  getPropertyById(Long id);

    void saveProperty(Property property);

    void deletePropertyById(Long id);

    Parameter createParameter(ParameterType parameterType);

    Optional<Parameter> getParameterById(Long id);

    void saveParameter(Parameter parameter);

    void deleteParameterById(Long id);
}
