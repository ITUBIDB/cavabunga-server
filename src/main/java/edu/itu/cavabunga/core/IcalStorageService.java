package edu.itu.cavabunga.core;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.component.Calendar;
import edu.itu.cavabunga.core.entity.component.ComponentType;
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
}