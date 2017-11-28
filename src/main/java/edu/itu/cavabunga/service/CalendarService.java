package edu.itu.cavabunga.service;


import edu.itu.cavabunga.entity.Calendar;
import edu.itu.cavabunga.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;

    public List<Calendar> getAllCalendars(){
        List<Calendar> calendars = new ArrayList<>();
        calendarRepository.findAll().forEach(calendars::add);
        return calendars;
    }

    public Calendar getCalendar(Long id){
        return calendarRepository.findOne(id);
    }

    public void addCalendar(Calendar calendar){
        calendarRepository.save(calendar);
    }

    public void updateCalendar(Calendar calendar){
        calendarRepository.save(calendar);
    }

    public void deleteCalendar(Long id){
        calendarRepository.delete(id);
    }
}
