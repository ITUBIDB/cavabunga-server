package edu.itu.cavabunga.core;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.component.Calendar;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.exception.IcalStorageException;
import edu.itu.cavabunga.core.factory.ComponentFactory;
import edu.itu.cavabunga.core.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IcalStorageService {
    @Autowired
    public ComponentFactory componentFactory;

    @Autowired
    public ComponentRepository componentRepository;

    @Autowired
    public ParticipantStorageService participantStorageService;

    public void createCalendar(){
        componentRepository.save(componentFactory.createComponent(ComponentType.CALENDAR));
    }

    public Component createCalendar(Participant participant){
        Component calendar = componentFactory.createComponent(ComponentType.CALENDAR);
        calendar.setOwner(participant);
        componentRepository.save(calendar);
        return calendar;
    }

    public void saveCalendar(Calendar calendar){
        calendar.validate();
        componentRepository.save(calendar);
    }

    public Component getCalendarById(Long id){
        return componentRepository.findById(id);
    }

    public List<Component> getCalendarByOwner(String user_name){
        return componentRepository.findByOwnerAndComponentToComponentMapIsNull(participantStorageService.getParticipantByUserName(user_name));
    }

    public Iterable<Component> getAllCalendars(){
        return componentRepository.findAll();
    }

    //-------------------------------------

    public Component createComponent(ComponentType componentType) throws IcalStorageException{
        Component result = componentFactory.createComponent(componentType);
        if(result == null){
            throw new IcalStorageException("Cant create component in IcalStorageService.");
        }

        return result;
    }

    public Component createComponentForParticipant(ComponentType componentType, Participant participant){
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

    public Component getComponentById(Long id){
        Component result = componentRepository.findOne(id);
        if(result == null){
            throw new IcalStorageException("Cant find component with given id: " + id);
        }

        return result;
    }

    public List<Component> getComponentByParticipant(Participant participant){
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

    public List<Component> getSpecificComponentsOfParticipant(ComponentType componentType, Participant participant){
        if(componentType == null || participant == null){
            throw new IcalStorageException("Cant reach componentType or participant in IcalStorageService");
        }

        List<Component> result = componentRepository.findByComponentTypeAndOwner(componentType.toString(), participant);
        if(result == null || result.size() == 0){
            throw new IcalStorageException("Cant find specific object: " + componentType.toString() + " for participant: " + participant.getUserName());
        }
        return result;
    }


}
