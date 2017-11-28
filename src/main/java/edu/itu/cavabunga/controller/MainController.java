package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.entity.Calendar;
import edu.itu.cavabunga.entity.Component;
import edu.itu.cavabunga.repository.CalendarRepository;
import edu.itu.cavabunga.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/calendar")
public class MainController {
    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewCalendar(@RequestParam String calendar_name,
                                               @RequestParam String user_name,
                                               @RequestParam String component_type){

        Component e = new Component();
        e.setComponent_type(component_type);

        Calendar c = new Calendar();
        c.setCalendar_name(calendar_name);
        c.setUser_name(user_name);
        c.addComponent(e);

        componentRepository.save(e);
        calendarRepository.save(c);
        return "kayit tamamlandi";
    }

    @GetMapping(path="/showcalendars")
    public @ResponseBody Iterable<Calendar> getAllCalendars(){
        return calendarRepository.findAll();
    }
}
