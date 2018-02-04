package edu.itu.cavabunga.core.controller;

import edu.itu.cavabunga.core.services.IcalService;
import edu.itu.cavabunga.core.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/api")
public class CalendarController {
    @Autowired
    IcalService icalService;

    @Autowired
    ParticipantService participantService;


}