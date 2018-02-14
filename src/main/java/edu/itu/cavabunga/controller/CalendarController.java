package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.controller.wrapper.CalendarResponse;
import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.entity.property.PropertyType;
import edu.itu.cavabunga.exception.IcalNotFound;
import edu.itu.cavabunga.exception.ParticipantNotFound;
import edu.itu.cavabunga.core.services.IcalService;
import edu.itu.cavabunga.core.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/calendar")
public class CalendarController {
    @Autowired
    IcalService icalService;

    @Autowired
    ParticipantService participantService;

    @PostMapping("/{userName}")
    @ResponseStatus(HttpStatus.CREATED)
    CalendarResponse saveCalendar(@RequestBody edu.itu.cavabunga.core.entity.Component calendar, @PathVariable String userName){
        Participant participant = participantService.getParticipantByUserName(userName);
        if(participant == null){
            throw new ParticipantNotFound("kullanici bulunamadi " + userName);
        }

        calendar.setOwner(participant);
        icalService.saveComponent(calendar);
        return new CalendarResponse(0,"takvim basari ile kaydedildi", null);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    CalendarResponse getAllCalendars(){
        List<Component> calendars = icalService.getAllComponentByType(ComponentType.Calendar);
        if(calendars.isEmpty()){
            throw new IcalNotFound("sistemde kayıtlı takvim yok");
        }

        return new CalendarResponse(0,null, calendars);
    }

    @GetMapping("/{userName}")
    @ResponseStatus(HttpStatus.OK)
    CalendarResponse getCalendar(@PathVariable("userName") String userName){
        Participant participant = participantService.getParticipantByUserName(userName);
        if(participant == null){
            throw new ParticipantNotFound("kullanici bulunamdı " + userName);
        }

        List<Component> calendar = icalService.getComponentByParticipantAndType(participant, ComponentType.Calendar);
        if(calendar.isEmpty()){
            throw new IcalNotFound(userName + " icin takvim bulunamadi");
        }

        return new CalendarResponse(0,null,calendar);
    }

    @DeleteMapping("/{calendarId}")
    @ResponseStatus(HttpStatus.OK)
    CalendarResponse deleteCalendar(@PathVariable("calendarId") Long id){
        Component calendar = icalService.getComponentById(id);
        if(calendar == null){
            throw new IcalNotFound(id + " ile bir takvim bulunamadı");
        }

        icalService.deleteComponent(calendar);
        return new CalendarResponse(0,"takvim basari ile silindi", null);
    }

    @PutMapping("/{calendarId}")
    @ResponseStatus(HttpStatus.OK)
    CalendarResponse updateCalendar(@RequestBody Component calendar, @PathVariable("calendarId") Long id){
        Component checkCalendar = icalService.getComponentById(id);
        if(checkCalendar == null){
            throw new IcalNotFound(id + " ile bir takvim bulunamadı.");
        }

        calendar.setId(id);
        icalService.saveComponent(calendar);
        return new CalendarResponse(0,"takvim basari ile guncellendi",null);
    }

    @GetMapping("/testcalendarcelikd")
    @ResponseStatus(HttpStatus.OK)
    void testCalendar(){
        Participant participant = participantService.getParticipantByUserName("celikd");


        Component calendar = icalService.createComponent(ComponentType.Calendar);
        Property calscale = icalService.createProperty(PropertyType.Calscale);
            calscale.setValue("GREGODIAN");
        Property prodid = icalService.createProperty(PropertyType.Prodid);
            prodid.setValue("CAVabunga caldav server 0.1");
        calendar.addProperty(calscale);
        calendar.addProperty(prodid);

        Component event = icalService.createComponent(ComponentType.Event);
        Property dtstamp = icalService.createProperty(PropertyType.Dtstamp);
            dtstamp.setValue("1234201803Z");
        Property location = icalService.createProperty(PropertyType.Location);
            location.setValue("BIDB");

            event.addProperty(dtstamp);
            event.addProperty(location);

            calendar.addComponent(event);
            calendar.setOwner(participant);
        icalService.saveComponent(calendar);
    }
}