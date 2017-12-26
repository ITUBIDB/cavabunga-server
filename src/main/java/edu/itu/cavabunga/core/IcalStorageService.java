package edu.itu.cavabunga.core;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.property.PropertyType;
import edu.itu.cavabunga.core.exception.IcalStorageException;
import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.factory.ParameterFactory;
import edu.itu.cavabunga.core.factory.PropertyFactory;
import edu.itu.cavabunga.core.repository.ComponentRepository;
import edu.itu.cavabunga.core.repository.ParameterRepository;
import edu.itu.cavabunga.core.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IcalStorageService {
    @Autowired
    public ParticipantStorageService participantStorageService;

    @Autowired
    public ComponentFactory componentFactory;

    @Autowired
    public ComponentRepository componentRepository;

    @Autowired
    public PropertyFactory propertyFactory;

    @Autowired
    public PropertyRepository propertyRepository;

    @Autowired
    public ParameterFactory parameterFactory;

    @Autowired
    public ParameterRepository parameterRepository;

    public Component createComponent(ComponentType componentType) throws IcalStorageException{
        Component result = componentFactory.createComponent(componentType);
        if(result == null){
            throw new IcalStorageException("Cant create component in IcalStorageService.");
        }

        return result;
    }

    public Component createComponentForParticipant(ComponentType componentType, Participant participant) throws IcalStorageException{
        Component result = componentFactory.createComponent(componentType);
        if(participant == null){
            throw new IcalStorageException("Cant reach participant object in IcalStorageService");
        }

        if(result == null){
            throw new IcalStorageException("Cant create component in IcalStorageService");
        }

        result.setOwner(participant);
        return result;
    }

    public Component getComponentById(Long id) throws IcalStorageException{
        Component result = componentRepository.findOne(id);
        if(result == null){
            throw new IcalStorageException("Cant find component with given id: " + id);
        }

        return result;
    }

    public List<Component> getComponentByParticipant(Participant participant) throws IcalStorageException{
        List<Component> result = componentRepository.findByOwner(participant);
        if(participant == null){
            throw new IcalStorageException("Cant reach participant object in IcalStorageService");
        }

        if(result == null || result.size() == 0){
            throw new IcalStorageException("Cant find components with given participant: " + participant.getUserName()
            );
        }

        return result;
    }

    public List<Component> getSpecificComponentsOfParticipant(ComponentType componentType, Participant participant) throws IcalStorageException{
        if(componentType == null || participant == null){
            throw new IcalStorageException("Cant reach componentType or participant in IcalStorageService");
        }

        List<Component> result = componentRepository.findByComponentTypeAndOwner(componentType.toString(), participant);
        if(result == null || result.size() == 0){
            throw new IcalStorageException("Cant find specific object: " + componentType.toString() + " for participant: " + participant.getUserName());
        }
        return result;
    }

    public void saveComponent(Component component) throws IcalStorageException{
        componentRepository.save(component);
    }

    public Property createProperty(PropertyType propertyType) throws IcalStorageException{
        Property result = propertyFactory.createProperty(propertyType);
        if (result == null){
            throw new IcalStorageException("Object cant crated in IcalStorageService: " + propertyType.toString());
        }
        return result;
    }

    public Property getPropertyById(Long id) throws IcalStorageException{
        Property result = propertyRepository.findOne(id);
        if(result == null){
            throw new IcalStorageException("Cant find object in IcalStroageService");
        }
        return result;
    }

    public List<Property> getPropertyByComponent(Component component){
        List<Property> result = propertyRepository.findByComponentToPropertyMap(component);
        if(result == null || result.size() == 0){
            throw new IcalStorageException("Cant get object from reposityory in IcalStorageService");
        }

        return result;
    }
}
