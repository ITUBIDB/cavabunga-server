package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.entity.Component;
import edu.itu.cavabunga.entity.Parameter;
import edu.itu.cavabunga.entity.Property;
import edu.itu.cavabunga.repository.ComponentRepository;
import edu.itu.cavabunga.repository.ParameterRepository;
import edu.itu.cavabunga.repository.PropertyRepository;
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
    private PropertyRepository propertyRepository;

    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ParameterRepository parameterRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewCalendar(@RequestParam String calendar_name,
                                               @RequestParam String user_name,
                                               @RequestParam String component_type,
                                               @RequestParam String property_name,
                                               @RequestParam String property_value){
        Parameter r = new Parameter();
        r.setName("pr1");
        r.setValue("rrr");

        Property p = new Property();
        p.setName(property_name);
        p.setValue(property_value);
        p.addParameter(r);

        Component e2 = new Component();
        e2.setComponent_type(component_type);

        Component e = new Component();
        e.setComponent_type("CALENDAR");
        e.setOwner(user_name);

        e.addProperty(p);
        e.addComponent(e2);

        parameterRepository.save(r);
        propertyRepository.save(p);
        componentRepository.save(e);
        componentRepository.save(e2);
        return "kayit tamamlandi";
    }

    @GetMapping(path="/showcalendars")
    public @ResponseBody Iterable<Component> getAllComponents(){
        return componentRepository.findAll();
    }
}
