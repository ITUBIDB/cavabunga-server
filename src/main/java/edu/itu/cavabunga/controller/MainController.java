package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.entity.Component;
import edu.itu.cavabunga.entity.ComponentFactory;
import edu.itu.cavabunga.entity.component.ComponentType;
import edu.itu.cavabunga.repository.ComponentRepository;
import edu.itu.cavabunga.repository.ParameterRepository;
import edu.itu.cavabunga.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/calendar")
public class MainController {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ParameterRepository parameterRepository;

    @Autowired
    private ComponentFactory componentFactory;

    @GetMapping(path="/add")
    public @ResponseBody String addNewCalendar(){
        componentFactory.createComponent(ComponentType.CALENDAR);
        return "kayit tamamlandi";
    }

    @GetMapping(path="/showcalendars")
    public @ResponseBody Iterable<Component> getAllComponents(){
        return componentRepository.findAll();
    }
}
