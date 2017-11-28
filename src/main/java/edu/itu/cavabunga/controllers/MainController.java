package edu.itu.cavabunga.controllers;

import edu.itu.cavabunga.entities.Calendar;
import edu.itu.cavabunga.repositories.CalendarRepository;
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

    @GetMapping(path="/add")
    public @ResponseBody String addNewCalendar(@RequestParam String calendar_name, @RequestParam String user_name){
        Calendar c = new Calendar();
        c.setCalendar_name(calendar_name);
        c.setUser_name(user_name);
        calendarRepository.save(c);
        return "kayit tamamlandi";
    }

    @GetMapping(path="/showcalendars")
    public @ResponseBody Iterable<Calendar> getAllCalendars(){
        return calendarRepository.findAll();
    }
}
