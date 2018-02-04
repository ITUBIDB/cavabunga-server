package edu.itu.cavabunga.core.services;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.parameter.ParameterType;
import edu.itu.cavabunga.core.entity.property.PropertyType;
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
public class IcalServiceImpl {
    @Autowired
    private ParticipantServiceImpl participantServiceImpl;

    @Autowired
    private ComponentFactory componentFactory;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private PropertyFactory propertyFactory;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ParameterFactory parameterFactory;

    @Autowired
    private ParameterRepository parameterRepository;

    public Component createComponent(ComponentType componentType){
        return componentFactory.createComponent(componentType);
    }

    public Component createComponentForParticipant(ComponentType componentType, Participant participant){
        Component result = componentFactory.createComponent(componentType);
        result.setOwner(participant);
        return result;
    }

    public Component getComponentById(Long id){
        return componentRepository.findOne(id);
    }

    public List<Component> getComponentByParent(Component component){
        return componentRepository.findByParent(component);
    }

    public List<Component> getComponentByParentAndType(Component component, ComponentType componentType){
        return componentRepository.findByParentAndType(component, componentType.toString());
    }

    public List<Component> getComponentByParticipant(Participant participant){
        return componentRepository.findByOwner(participant);
    }

    public List<Component> getAllComponentByType(ComponentType componentType){
        return componentRepository.findByType(componentType.toString());
    }

    public List<Component> getComponentByParticipantAndType(Participant participant, ComponentType componentType){
        return componentRepository.findByOwnerAndType(participant, componentType.toString());
    }

    public Iterable<Component> getAllComponent(){
        return componentRepository.findAll();
    }

    public void saveComponent(Component component){
        componentRepository.save(component);
    }

    public void deleteComponentById(Long id){
        componentRepository.delete(id);
    }

    public void deleteComponent(Component component){
        componentRepository.delete(component.getId());
    }


    public Property createProperty(PropertyType propertyType){
       return  propertyFactory.createProperty(propertyType);
    }

    public Property createPropertyForComponent(PropertyType propertyType, Component component){
        Property result = propertyFactory.createProperty(propertyType);
        result.setComponent(component);
        return result;
    }

    public Property getPropertyById(Long id){
        return propertyRepository.findOne(id);
    }

    public List<Property> getPropertyByComponent(Component component){
         return propertyRepository.findByComponent(component);
    }

    public List<Property> getAllPropertyByType(PropertyType propertyType){
        return propertyRepository.findByType(propertyType.toString());
    }

    public List<Property> getPropertyByComponentAndType(Component component, PropertyType propertyType){
        return propertyRepository.findByComponentAndType(component, propertyType.toString());
    }

    public Iterable<Property> getAllProperty(){
        return propertyRepository.findAll();
    }

    public void saveProperty(Property property){
        propertyRepository.save(property);
    }

    public void deletePropertyById(Long id){
        propertyRepository.delete(id);
    }

    public void deleteProperty(Property property){
        propertyRepository.delete(property.getId());
    }


    public Parameter createParameter(ParameterType parameterType){
        return parameterFactory.createParameter(parameterType);
    }

    public Parameter createParameterForProperty(ParameterType parameterType, Property property){
        Parameter result = parameterFactory.createParameter(parameterType);
        result.setProperty(property);
        return result;
    }

    public Parameter getParameterById(Long id){
        return parameterRepository.findOne(id);
    }

    public List<Parameter> getParameterByProperty(Property property){
        return parameterRepository.findByProperty(property);
    }

    public List<Parameter> getAllParameterByType(ParameterType parameterType){
        return parameterRepository.findByType(parameterType.toString());
    }

    public List<Parameter> getParameterByPropertyAndType(Property property, ParameterType parameterType){
        return parameterRepository.findByPropertyAndType(property, parameterType.toString());
    }

    public Iterable<Parameter> getAllParameter(){
        return parameterRepository.findAll();
    }

    public void saveParameter(Parameter parameter){
        parameterRepository.save(parameter);
    }

    public void deleteParameterById(Long id){
        parameterRepository.delete(id);
    }

    public void deleteParameter(Parameter parameter){
        parameterRepository.delete(parameter.getId());
    }
}
