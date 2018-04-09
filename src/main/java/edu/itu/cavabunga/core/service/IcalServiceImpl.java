package edu.itu.cavabunga.core.service;
import java.util.Optional;
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

@Service
public class IcalServiceImpl implements IcalService {
    private ComponentFactory componentFactory;

    private ComponentRepository componentRepository;

    private PropertyFactory propertyFactory;

    private PropertyRepository propertyRepository;

    private ParameterFactory parameterFactory;

    private ParameterRepository parameterRepository;

    @Autowired
    public IcalServiceImpl(
        ComponentFactory componentFactory,
        ComponentRepository componentRepository,
        PropertyFactory propertyFactory,
        PropertyRepository propertyRepository,
        ParameterFactory parameterFactory,
        ParameterRepository parameterRepository
    ) {
        this.componentFactory = componentFactory;
        this.componentRepository = componentRepository;
        this.propertyFactory = propertyFactory;
        this.propertyRepository = propertyRepository;
        this.parameterFactory = parameterFactory;
        this.parameterRepository = parameterRepository;
    }

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
    public Optional<Component> getComponentById(Long id){
        return componentRepository.findById(id);
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
    public Property createProperty(PropertyType propertyType){
        return  propertyFactory.createProperty(propertyType);
    }

    @Override
    public Optional<Property> getPropertyById(Long id){
        return propertyRepository.findById(id);
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
    public Parameter createParameter(ParameterType parameterType){
        return parameterFactory.createParameter(parameterType);
    }

    @Override
    public Optional<Parameter> getParameterById(Long id){
        return parameterRepository.findById(id);
    }


    @Override
    public void saveParameter(Parameter parameter){
        parameterRepository.save(parameter);
    }

    @Override
    public void deleteParameterById(Long id){
        parameterRepository.delete(id);
    }
}
