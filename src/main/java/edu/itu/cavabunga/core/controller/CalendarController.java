package edu.itu.cavabunga.core.controller;

import edu.itu.cavabunga.core.services.IcalServiceImpl;
import edu.itu.cavabunga.core.services.ParticipantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/api")
public class CalendarController {
    @Autowired
    IcalServiceImpl icalServiceImpl;

    @Autowired
    ParticipantServiceImpl participantServiceImpl;


}