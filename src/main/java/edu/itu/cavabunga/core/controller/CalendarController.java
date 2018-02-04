package edu.itu.cavabunga.core.controller;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.exception.IcalNotFoundException;
import edu.itu.cavabunga.core.exception.ParticipantNotFoundException;
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
    ResultResponse saveCalendar(@RequestBody edu.itu.cavabunga.core.entity.Component calendar, @PathVariable String userName){
        Participant participant = participantService.getParticipantByUserName(userName);
        if(participant == null){
            throw new ParticipantNotFoundException("kullanici bulunamadi " + userName);
        }

        calendar.setOwner(participant);
        icalService.saveComponent(calendar);
        return new ResultResponse(0,"takvim basari ile kaydedildi", null);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResultResponse getAllCalendars(){
        List<Component> calendars = icalService.getAllComponentByType(ComponentType.Calendar);
        if(calendars.isEmpty()){
            throw new IcalNotFoundException("sistemde kayıtlı takvim yok");
        }

        return new ResultResponse(0,null, calendars);
    }

    @GetMapping("/{userName}")
    @ResponseStatus(HttpStatus.OK)
    ResultResponse getCalendar(@PathVariable String userName){
        Participant participant = participantService.getParticipantByUserName(userName);
        if(participant == null){
            throw new ParticipantNotFoundException("kullanici bulunamdı " + userName);
        }

        List<Component> calendar = icalService.getComponentByParticipantAndType(participant, ComponentType.Calendar);
        if(calendar == null){
            throw new IcalNotFoundException(userName + " icin takvim bulunamadi");
        }
        return new ResultResponse(0, null, calendar);
    }

    @DeleteMapping("/{calendarId}")
    @ResponseStatus(HttpStatus.OK)
    ResultResponse deleteCalendar(@PathVariable Long id){
        Component calendar = icalService.getComponentById(id);
        if(calendar == null){
            throw new IcalNotFoundException(id + " ile bir takvim bulunamadı");
        }

        icalService.deleteComponent(calendar);
        return new ResultResponse(0,"takvim basari ile silindi", null);
    }

    @PutMapping("/{calendarId}")
    @ResponseStatus(HttpStatus.OK)
    ResultResponse updateCalendar(@RequestBody Component calendar, @PathVariable Long id){
        Component checkCalendar = icalService.getComponentById(id);
        if(checkCalendar == null){
            throw new IcalNotFoundException(id + " ile bir takvim bulunamadı.");
        }

        calendar.setId(id);
        icalService.saveComponent(calendar);
        return new ResultResponse(0,"takvim basari ile guncellendi",null);
    }
}