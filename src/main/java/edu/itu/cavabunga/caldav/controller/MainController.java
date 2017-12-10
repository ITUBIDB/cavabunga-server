package edu.itu.cavabunga.caldav.controller;

import edu.itu.cavabunga.caldav.entity.Component;
import edu.itu.cavabunga.caldav.CalendarService;
import edu.itu.cavabunga.user.User;
import edu.itu.cavabunga.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/calendar")
public class MainController {
    @Autowired
    private CalendarService calendarService;

    @Autowired
    private UserService userService;

    @GetMapping(path="/add")
    public @ResponseBody String test(){
        User user = userService.createUser("ali veli");
        calendarService.createCalendar();
        return "tamam";
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
