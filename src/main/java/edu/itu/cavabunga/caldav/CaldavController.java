package edu.itu.cavabunga.caldav;

import edu.itu.cavabunga.core.CalendarService;
import edu.itu.cavabunga.core.ParticipantService;
import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/calendar")
public class CaldavController {
    @Autowired
    private CalendarService calendarService;

    @Autowired
    private ParticipantService participantService;

    @GetMapping(path="/add")
    public @ResponseBody String test(){
        Participant participant = participantService.createParticipant("ali veli");
        calendarService.createCalendar();
        return "tamam";
    }

    @GetMapping(path="/get/i")
    public @ResponseBody Component getCalendarById(@RequestParam Long id){
        return calendarService.getCalendarById(id);
    }

    @GetMapping(path="/get/u")
    public @ResponseBody
    List<Component> getCalendarByUser(@RequestParam String user_name){
        return calendarService.getCalendarByOwner(user_name);
    }

    @GetMapping(path="/participant/u")
    public @ResponseBody Participant getParticipantByUserName(@RequestParam String user_name){
        return participantService.getParticipantByUserName(user_name);
    }

    @GetMapping(path="/participant/i")
    public @ResponseBody Participant getParticipantById(@RequestParam String uuid){
        return participantService.getParticipantByUuid(uuid);
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Component> createNewUser(){
        return calendarService.getAllCalendars();
    }
    /*
    public @ResponseBody String addNewCalendar(){
        componentFactory.createComponent(ComponentType.CALENDAR);
        return "kayit tamamlandi";
    }




    @GetMapping(path="/showcalendars")
    public @ResponseBody Iterable<Component> getAllComponents(){
        return componentRepository.findAll();
    } */

}
