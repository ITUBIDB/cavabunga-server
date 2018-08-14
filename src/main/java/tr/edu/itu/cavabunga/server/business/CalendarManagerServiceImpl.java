package tr.edu.itu.cavabunga.server.business;

import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.Parameter;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.lib.entity.Property;
import tr.edu.itu.cavabunga.server.service.ElementService;
import tr.edu.itu.cavabunga.server.service.ParticipantService;
import tr.edu.itu.cavabunga.lib.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class CalendarManagerServiceImpl implements CalendarManagerService {

    private ElementService elementService;

    private ParticipantService participantService;

    @Autowired
    public CalendarManagerServiceImpl(ElementService elementService, ParticipantService participantService) {
        this.elementService = elementService;
        this.participantService = participantService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addParticipant(Participant participant){
        Assert.notNull(participant.getUserName(), "Participant must not be null!");
        Assert.state(
                participant.getId() == null,
                "New participant cannot have id field, please use update methods"
        );

        if(participantService.getParticipantByUserName(participant.getUserName()).isPresent()) {
            throw new Conflict("Participant with username: " + participant.getUserName() + " is already exist.");
        }

        participantService.saveParticipant(participant);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Participant getParticipantByUserName(String userName){
        Assert.notNull(userName, "Username must not be null!");

        if(!participantService.getParticipantByUserName(userName).isPresent()) {
            throw new NotFound("Participant with username: " + userName + " couldn't found");
        }

        return participantService.getParticipantByUserName(userName).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Participant> getAllParticipants(){
        return participantService.getAllParticipant();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteParticipantById(Long id){
        Assert.notNull(id, "");

        if(!participantService.getParticipantById(id).isPresent()) {
            throw new NotFound("Participant with id: " + id + " couldn't found");
        }

        participantService.deleteParticipantById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateParticipant(Long id, Participant participant){
        Assert.notNull(id, "Id must not be null!");
        Assert.notNull(participant, "Participant must not be null!");
        Assert.isTrue(id.equals(participant.getId()), "ID doesn't match!");

        if(!participantService.getParticipantById(id).isPresent()) {
            throw new NotFound("Participant with id: " + id + " couldn't found");
        }

        participantService.saveParticipant(participant);
    }

    /**
     * {@inheritDoc}
     */
    @Override

    public void addComponent(Component component, String owner, Long parentComponentId){
        Assert.notNull(component, "Component must not be null!");
        Assert.notNull(owner, "Username must not be null!");
        Assert.notNull(parentComponentId, "ParentComponentId must not be null!");

        Assert.state(
                component.getId() == null,
                "44New component cannot have id field, please use update methods"
        );

        if(!participantService.getParticipantByUserName(owner).isPresent()) {
            throw new NotFound("owner: " + owner + " couldn't found");
        }
        if(!elementService.getComponentById(parentComponentId).isPresent()) {
            throw new NotFound("Parent component not found");
        }

        component.setOwner(participantService.getParticipantByUserName(owner).get());
        component.setParent(elementService.getComponentById(parentComponentId).get());
        elementService.saveComponent(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Component getComponentById(Long id){
        Assert.notNull(id, "Id must not be null!");

        if(!elementService.getComponentById(id).isPresent()) {
            throw new NotFound("Component with ID: " + id + " couldn't found");
        }

        return elementService.getComponentById(id).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Component> getComponentByOwner(String owner){
        Assert.notNull(owner, "Owner participant cannot be null");

        if(!participantService.getParticipantByUserName(owner).isPresent()){
            throw new NotFound("No participant found for username: " + owner);
        }

        return elementService.getComponentByOwner(participantService.getParticipantByUserName(owner).get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteComponentById(Long id){
        Assert.notNull(id, "Id must not be null!");

        if(!elementService.getComponentById(id).isPresent()) {
            throw new NotFound("Component with ID: " + id + " couldn't found");
        }

        elementService.deleteComponentById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateComponent(Long id, Component component){
        Assert.notNull(id, "Id must not be null!");
        Assert.notNull(component, "Component must not be null!");
        Assert.isTrue(id.equals(component.getId()), "ID doesn't match!");

        if(!elementService.getComponentById(id).isPresent()) {
            throw new NotFound("Component with ID: " + id + " couldn't found");
        }

        elementService.saveComponent(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addProperty(Property property, Long parentComponentId){
        Assert.notNull(property, "Property must not be null!");
        Assert.notNull(parentComponentId, "ParentComponentId must not be null!");
        Assert.state(
                property.getId() == null,
                "55New Property cannot have id field, please use update methods"
        );

        if(!elementService.getComponentById(parentComponentId).isPresent()) {
            throw new NotFound("Parent component not found");
        }

        property.setComponent(elementService.getComponentById(parentComponentId).get());
        elementService.saveProperty(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Property getPropertyById(Long propertyId){
        Assert.notNull(propertyId, "Id must not be null!");

        if(!elementService.getPropertyById(propertyId).isPresent()) {
            throw new NotFound("Property with ID: " + propertyId + " couldn't found");
        }

        return elementService.getPropertyById(propertyId).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Property> getPropertiesOfComponent(Long componentId){
        Assert.notNull(componentId, "Id must not be null!");

        if(!elementService.getComponentById(componentId).isPresent()) {
            throw new NotFound("Component with ID: " + componentId + " couldn't found");
        }
        return elementService.getComponentById(componentId).get().getProperties();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteProperty(Long propertyId){
        Assert.notNull(propertyId, "Id must not be null!");

        if(!elementService.getComponentById(propertyId).isPresent()) {
            throw new NotFound("Property with ID: " + propertyId + " couldn't found");
        }

        elementService.deletePropertyById(propertyId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateProperty(Long propertyId, Property property){
        Assert.notNull(propertyId, "Id must not be null!");
        Assert.notNull(property, "Property must not be null!");
        Assert.state(propertyId.equals(property.getId()), "ID doesn't match!");

        if(!elementService.getComponentById(propertyId).isPresent()) {
            throw new NotFound("Property with ID: " + propertyId + " couldn't found");
        }

        elementService.saveProperty(property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addParameter(Parameter parameter, Long parentPropertyId){
        Assert.notNull(parameter, "Parameter must not be null!");
        Assert.notNull(parentPropertyId, "ParentPropertyId must not be null!");
        Assert.state(
                parameter.getId() == null,
                "77New parameter cannot have id field, please use update methods"
        );

        if(!elementService.getPropertyById(parentPropertyId).isPresent()) {
            throw new NotFound("Parent property not found");
        }
        parameter.setProperty(elementService.getPropertyById(parentPropertyId).get());
        elementService.saveParameter(parameter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Parameter getParameterById(Long parameterId){
        Assert.notNull(parameterId, "Id must not be null!");

        if(!elementService.getParameterById(parameterId).isPresent()) {
            throw new NotFound("Parameter with ID: " + parameterId + " couldn't found");
        }

        return elementService.getParameterById(parameterId).get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Parameter> getParametersOfProperty(Long propertyId){
        Assert.notNull(propertyId, "Id must not be null!");

        if(!elementService.getPropertyById(propertyId).isPresent()) {
            throw new NotFound("Property with ID: " + propertyId + " couldn't found");
        }
        return elementService.getPropertyById(propertyId).get().getParameters();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteParameter(Long parameterId){
        Assert.notNull(parameterId, "Id must not be null!");

        if(!elementService.getParameterById(parameterId).isPresent()) {
            throw new NotFound("Parameter with ID: " + parameterId + " couldn't found");
        }

        elementService.deleteParameterById(parameterId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateParameter(Parameter parameter, Long parameterId){
        Assert.notNull(parameter, "parameter must not be null!");
        Assert.notNull(parameterId, "parameterId must not be null!");
        Assert.state(parameterId.equals(parameter.getId()), "ID doesn't match!");

        if(!elementService.getParameterById(parameterId).isPresent()) {
            throw new NotFound("Parameter with ID: " + parameterId + " couldn't found");
        }

        elementService.saveParameter(parameter);
    }
}
