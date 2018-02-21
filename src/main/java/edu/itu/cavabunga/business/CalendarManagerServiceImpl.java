package edu.itu.cavabunga.business;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;
import edu.itu.cavabunga.core.services.IcalService;
import edu.itu.cavabunga.core.services.ParticipantService;
import edu.itu.cavabunga.exception.ComponentNotFound;
import edu.itu.cavabunga.exception.ParticipantConflict;
import edu.itu.cavabunga.exception.ParticipantNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarManagerServiceImpl {
    @Autowired
    private IcalService icalService;

    @Autowired
    private ParticipantService participantService;

    public Participant createParticipant(String userName, ParticipantType participantType){
        Participant checkParticipant = participantService.getParticipantByUserName(userName);
        if(checkParticipant != null){
            throw new ParticipantConflict("1001 - Participant with username: " + userName + " is already exists");
        }

        return participantService.createParticipant(userName, participantType);
    }

    public Participant getParticipantByUserName(String userName){
        Participant checkParticipant = participantService.getParticipantByUserName(userName);
        if(checkParticipant == null){
            throw new ParticipantNotFound("1002 - Participant with username: " + userName + "cannot found");
        }

        return checkParticipant;
    }

    public Participant getParticipantById(Long id){
        Participant checkParticipant = participantService.getParticipantById(id);
        if(checkParticipant == null){
            throw new ParticipantNotFound("1003 - Participant with id: " + id + "cannot found");
        }

        return checkParticipant;
    }

    public List<Participant> getAllParticipantsByType(ParticipantType participantType){
        List<Participant> participants = participantService.getAllParticipantByType(participantType);
        if(participants.isEmpty()){
            throw new ParticipantNotFound("1004 - There is no participants in type of : " + participantType.toString());
        }

        return participants;
    }

    public List<Participant> getAllParticipants(){
        List<Participant> participants = participantService.getAllParticipant();
        if(participants.isEmpty()){
            throw new ParticipantNotFound("1005 - No participant found");
        }

        return participants;
    }

    public void deleteParticipantById(Long id){
        Participant checkParticipant = participantService.getParticipantById(id);
        if(checkParticipant == null){
            throw new ParticipantNotFound("1006 - Participant with id: " + id + " cannot found");
        }

        participantService.deleteParticipantById(id);
    }

    public void deleteParticipantByUserName(String userName){
        Participant checkParticipant = participantService.getParticipantByUserName(userName);
        if(checkParticipant == null){
            throw new ParticipantNotFound("1007 - Participant with username: " + userName + " cannot found");
        }

        participantService.deleteParticipantByUserName(userName);
    }

    public void updateParticipant(Long id, Participant participant){
        Participant checkParticipant = participantService.getParticipantById(id);
        if(checkParticipant == null){
            throw new ParticipantNotFound("1008 - Participant with id: " + id + " cannot found");
        }

        checkParticipant.setId(id);
        participantService.saveParticipant(checkParticipant);
    }


    public void saveParticipant(Participant participant){
        participantService.saveParticipant(participant);
    }

    public Component createComponent(ComponentType componentType){
        return icalService.createComponent(componentType);
    }

    public Component createComponentForParticipant(ComponentType componentType, String userName){
        Participant checkParticipant = participantService.getParticipantByUserName(userName);
        if(checkParticipant == null){
            throw new ParticipantNotFound("1009 - Parcitipant with userName: " + userName + "cannot found");
        }

        Component component = icalService.createComponentForParticipant(componentType, checkParticipant);
        return component;
    }

    public Component getComponetnById(Long id){
        Component checkComponent = icalService.getComponentById(id);
        if(checkComponent == null){
            throw new ComponentNotFound("1010 - Component with id: " + id + "not found");
        }

        return checkComponent;
    }

    public List<Component> getComponentByParent(Component component){
        List<Component> checkComponent = icalService.getComponentByParent(component);
        if(checkComponent.isEmpty()){
            throw new ComponentNotFound("1011 - Component's child object for parent id: " + component.getId() + "cannot found");
        }

        return checkComponent;
    }

    public List<Component> getComponentByParentAndType(Long componentId, ComponentType componentType){
        Component component = icalService.getComponentById(componentId);
        if(component == null){
            throw new ComponentNotFound("xxx - Component with id: " + componentId + " cannot found");
        }


        List<Component> checkComponent = icalService.getComponentByParentAndType(component, componentType);
        if(checkComponent.isEmpty()){
            throw new ComponentNotFound("1012 - Component's child object for parent id: " + component.getId() + " and for type " + componentType.toString() + " cannot found" );
        }

        return checkComponent;
    }

    public List<Component> getAllComponentsByParticipant(String userName){
        Participant checkParticipant = participantService.getParticipantByUserName(userName);
        if(checkParticipant == null){
            throw new ParticipantNotFound("XXXX - Participant with username: " + userName + " cannot found");
        }

        List<Component> checkComponent = icalService.getComponentByParticipant(checkParticipant);
        if(checkComponent.isEmpty()){
            throw new ComponentNotFound("XXXX - Component for participant: " + userName + " cannot found");
        }

        return checkComponent;
    }

    public List<Component> getComponentsByParticipantAndType(String userName, ComponentType componentType){
        Participant checkParticipant = participantService.getParticipantByUserName(userName);
        if(checkParticipant == null){
            throw new ParticipantNotFound("XXXX - Participant with username: " + userName + " cannot found");
        }

        List<Component> checkComponent = icalService.getComponentByParticipantAndType(checkParticipant, componentType);
        if(checkComponent.isEmpty()){
            throw new ComponentNotFound("XXXX - Component for participant: " + userName + " and type " + componentType.toString() + " is not found");
        }

        return checkComponent;
    }

    public List<Component> getAllComponentsByType(ComponentType componentType){
        List<Component> components = icalService.getAllComponentByType(componentType);
        if(components.isEmpty()){
            throw new ComponentNotFound("XXXX - Component for component type: " + componentType.toString() + " is not found");
        }

        return components;
    }

    public List<Component> getAllComponents(){
        List<Component> components = icalService.getAllComponent();
        if(components.isEmpty()){
            throw new ComponentNotFound("XXXX - No component found");
        }

        return components;
    }

    public void deleteComponentById(Long id){
        Component checkComponent = icalService.getComponentById(id);
        if(checkComponent == null){
            throw new ComponentNotFound("XXX - Component with id: " + id + "cannot found");
        }

        icalService.deleteComponentById(id);
    }

    public void saveComponent(Component component){
        icalService.saveComponent(component);
    }
}
