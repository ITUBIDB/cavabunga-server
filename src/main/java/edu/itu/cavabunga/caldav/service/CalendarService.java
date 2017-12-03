package edu.itu.cavabunga.caldav.service;

import edu.itu.cavabunga.caldav.entity.Component;
import edu.itu.cavabunga.caldav.entity.ComponentFactory;
import edu.itu.cavabunga.caldav.entity.component.Calendar;
import edu.itu.cavabunga.caldav.entity.component.ComponentType;
import edu.itu.cavabunga.caldav.repository.ComponentRepository;
import edu.itu.cavabunga.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    @Autowired
    public ComponentFactory componentFactory;

    @Autowired
    public ComponentRepository componentRepository;


    public void createCalendar(){
        componentRepository.save(componentFactory.createComponent(ComponentType.CALENDAR));
    }

    public Component createCalendar(User user){
        Component calendar = componentFactory.createComponent(ComponentType.CALENDAR);
        calendar.setOwner(user);
        componentRepository.save(calendar);
        return calendar;
    }

    public void saveCalendar(Calendar calendar){
        calendar.validate();
        componentRepository.save(calendar);
    }

    public Iterable<Component> getAllCalendars(){
        return componentRepository.findAll();
    }
}
