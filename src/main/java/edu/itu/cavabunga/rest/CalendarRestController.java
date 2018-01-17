package edu.itu.cavabunga.rest;

import edu.itu.cavabunga.core.IcalStorageService;
import edu.itu.cavabunga.core.ParticipantStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api")
public class CalendarRestController {
    @Autowired
    IcalStorageService icalStorageService;

    @Autowired
    ParticipantStorageService participantStorageService;

    @RequestMapping(path = "/participant", method = RequestMethod.POST)
    public @ResponseBody String createParticipant(@RequestBody ParticipantRest participant){
        return participant.getUserName() + " " + participant.getUuid() + " " + participant.getCreationDate();
    }

    @RequestMapping(path="/calendar", method = RequestMethod.POST)
    public @ResponseBody String createCalendar(@RequestBody CalendarRest calendar){
        String result = calendar.getCalendarName() + " " + calendar.getParticipant().getUserName();
        for(int i = 0; i < calendar.getEvent().size(); i++){
            result = result +  calendar.getEvent().get(i).getId() + " " + calendar.getEvent().get(i).getProperties().get(0).getName();
        }


        return  result;
    }
}