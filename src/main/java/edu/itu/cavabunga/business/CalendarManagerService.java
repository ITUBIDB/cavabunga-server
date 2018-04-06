package edu.itu.cavabunga.business;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;

import java.util.List;

public interface CalendarManagerService {
    //Participant section
    void addParticipant(Participant participant);

    Participant createParticipant(String userName, ParticipantType participantType);

    Participant getParticipantByUserName(String userName);

    List<Participant> getAllParticipants();

    void deleteParticipantById(Long id);

    void updateParticipant(Long id, Participant participant);

    //Component section
    void addComponent(Component component, String owner, Long parentComponentId);

    Component createComponentForParticipant(ComponentType componentType, String userName);

    Component getComponentById(Long id);

    void deleteComponentById(Long id);

    void updateComponent(Long id, Component component);

    //Property section
    void addProperty(Property property, String owner, Long parentComponentId);

    Property getPropertyById(Long propertyId);

    List<Property> getPropertiesOfComponent(Long componentId);

    void deleteProperty(Long propertyId);

    void updateProperty(Long propertyId, Property property);

    //Parameter section
    void addParameter(Parameter parameter, String owner, Long parentComponentId, Long parentPropertyId);

    Parameter getParameterById(Long parameterId);

    List<Parameter> getParametersOfProperty(Long propertyId);

    void deleteParameter(Long parameterId);

    void updateParameter(Parameter parameter, Long parameterId);
}
