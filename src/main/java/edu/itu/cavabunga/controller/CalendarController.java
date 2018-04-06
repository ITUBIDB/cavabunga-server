package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.business.CalendarManagerService;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;

import edu.itu.cavabunga.core.entity.component.ComponentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/calendar")
public class CalendarController {

    private CalendarManagerService calendarManagerService;

    @Autowired
    public CalendarController(CalendarManagerService calendarManagerService) {
        this.calendarManagerService = calendarManagerService;
    }

    @GetMapping(path = "/testcalendarcreate")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String test(){
        Participant celikd = calendarManagerService.createParticipant("celikd", ParticipantType.User);
        Participant sdg = calendarManagerService.createParticipant("sdg", ParticipantType.Group);

        calendarManagerService.createComponentForParticipant(ComponentType.Calendar, "username");
        return "ok";
    }
}