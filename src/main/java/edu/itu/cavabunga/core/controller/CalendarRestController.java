package edu.itu.cavabunga.core.controller;

import edu.itu.cavabunga.core.IcalStorageService;
import edu.itu.cavabunga.core.ParticipantStorageService;
import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.property.PropertyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/api")
public class CalendarRestController {
    @Autowired
    IcalStorageService icalStorageService;

    @Autowired
    ParticipantStorageService participantStorageService;


    @RequestMapping(path = "/participant", method = RequestMethod.POST)
    public @ResponseBody String createParticipant(@RequestBody Participant participant){
        participantStorageService.saveParticipant(participant);
        return "ok";
    }

    @RequestMapping(path = "/participant/{user_name}", method = RequestMethod.GET)
    public @ResponseBody Participant getParticipantByUserName(@PathVariable(value = "user_name") String user_name){
        return participantStorageService.getParticipantByUserName(user_name);
    }

    @RequestMapping(path = "/emptyparticipant/{user_name}", method = RequestMethod.GET)
    public @ResponseBody Participant createEmptyParticipant(@PathVariable(value = "user_name") String user_name){
        Participant test = participantStorageService.createParticipant(user_name);
        return test;
    }


    @RequestMapping(path="/calendar/{user_name}", method = RequestMethod.POST)
    public @ResponseBody String createCalendar(@PathVariable(value="user_name") String user_name){
        Participant participant = participantStorageService.getParticipantByUserName(user_name);
        if(participant == null){
            participant = participantStorageService.createParticipant(user_name);
        }
        Component cal = icalStorageService.createComponentForParticipant(ComponentType.Calendar, participant);
        Component event = icalStorageService.createComponent(ComponentType.Event);
        Property property = icalStorageService.createProperty(PropertyType.ACTION);
        event.addProperty(property);
        cal.addComponent(event);
        icalStorageService.saveComponent(cal);
        return "ok";
    }

    @RequestMapping(value = "/calendar/{user_name}", method = RequestMethod.GET)
    public @ResponseBody List<Component> getCalendarByUser(@PathVariable(value = "user_name") String user_name){
        Participant participant = participantStorageService.getParticipantByUserName(user_name);
        return icalStorageService.getComponentByParticipant(participant);
    }

    @RequestMapping(value = "/calendar", method = RequestMethod.POST)
    public @ResponseBody String postCalendar(@RequestBody Component calendar){
        icalStorageService.saveComponent(calendar);
        return "ok";
    }
}