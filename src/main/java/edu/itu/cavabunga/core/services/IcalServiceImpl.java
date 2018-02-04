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
public class IcalServiceImpl implements IcalService {
    @Autowired
    private ParticipantService participantService;

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

    @Override
    public Component createComponent(ComponentType componentType){
        return componentFactory.createComponent(componentType);
    }

    @Override
    public Component createComponentForParticipant(ComponentType componentType, Participant participant){
        Component result = componentFactory.createComponent(componentType);
        result.setOwner(participant);
        return result;
    }

    @Override
    public Component getComponentById(Long id){
        return componentRepository.findOne(id);
    }

    @Override
    public List<Component> getComponentByParent(Component component){
        return componentRepository.findByParent(component);
    }

    @Override
    public List<Component> getComponentByParentAndType(Component component, ComponentType componentType){
        return componentRepository.findByParentAndType(component, componentType.toString());
    }

    @Override
    public List<Component> getComponentByParticipant(Participant participant){
        return componentRepository.findByOwner(participant);
    }

    @Override
    public List<Component> getAllComponentByType(ComponentType componentType){
        return componentRepository.findByType(componentType.toString());
    }

    @Override
    public List<Component> getComponentByParticipantAndType(Participant participant, ComponentType componentType){
        return componentRepository.findByOwnerAndType(participant, componentType.toString());
    }

    @Override
    public Iterable<Component> getAllComponent(){
        return componentRepository.findAll();
    }

    @Override
    public void saveComponent(Component component){
        componentRepository.save(component);
    }

    @Override
    public void deleteComponentById(Long id){
        componentRepository.delete(id);
    }

    @Override
    public void deleteComponent(Component component){
        componentRepository.delete(component.getId());
    }


    @Override
    public Property createProperty(PropertyType propertyType){
       return  propertyFactory.createProperty(propertyType);
    }

    @Override
    public Property createPropertyForComponent(PropertyType propertyType, Component component){
        Property result = propertyFactory.createProperty(propertyType);
        result.setComponent(component);
        return result;
    }

    @Override
    public Property getPropertyById(Long id){
        return propertyRepository.findOne(id);
    }

    @Override
    public List<Property> getPropertyByComponent(Component component){
         return propertyRepository.findByComponent(component);
    }

    @Override
    public List<Property> getAllPropertyByType(PropertyType propertyType){
        return propertyRepository.findByType(propertyType.toString());
    }

    @Override
    public List<Property> getPropertyByComponentAndType(Component component, PropertyType propertyType){
        return propertyRepository.findByComponentAndType(component, propertyType.toString());
    }

    @Override
    public Iterable<Property> getAllProperty(){
        return propertyRepository.findAll();
    }

    @Override
    public void saveProperty(Property property){
        propertyRepository.save(property);
    }

    @Override
    public void deletePropertyById(Long id){
        propertyRepository.delete(id);
    }

    @Override
    public void deleteProperty(Property property){
        propertyRepository.delete(property.getId());
    }


    @Override
    public Parameter createParameter(ParameterType parameterType){
        return parameterFactory.createParameter(parameterType);
    }

    @Override
    public Parameter createParameterForProperty(ParameterType parameterType, Property property){
        Parameter result = parameterFactory.createParameter(parameterType);
        result.setProperty(property);
        return result;
    }

    @Override
    public Parameter getParameterById(Long id){
        return parameterRepository.findOne(id);
    }

    @Override
    public List<Parameter> getParameterByProperty(Property property){
        return parameterRepository.findByProperty(property);
    }

    @Override
    public List<Parameter> getAllParameterByType(ParameterType parameterType){
        return parameterRepository.findByType(parameterType.toString());
    }

    @Override
    public List<Parameter> getParameterByPropertyAndType(Property property, ParameterType parameterType){
        return parameterRepository.findByPropertyAndType(property, parameterType.toString());
    }

    @Override
    public Iterable<Parameter> getAllParameter(){
        return parameterRepository.findAll();
    }

    @Override
    public void saveParameter(Parameter parameter){
        parameterRepository.save(parameter);
    }

    @Override
    public void deleteParameterById(Long id){
        parameterRepository.delete(id);
    }

    @Override
    public void deleteParameter(Parameter parameter){
        parameterRepository.delete(parameter.getId());
    }
}
