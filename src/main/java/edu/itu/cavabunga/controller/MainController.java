package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.entity.Component;
import edu.itu.cavabunga.entity.Property;
import edu.itu.cavabunga.repository.ComponentRepository;
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

    @GetMapping(path="/add")
    public @ResponseBody String addNewCalendar(@RequestParam String calendar_name,
                                               @RequestParam String user_name,
                                               @RequestParam String component_type,
                                               @RequestParam String property_value,
                                               @RequestParam String property_key){
        Property p = new Property();
        p.setP_value(property_key);
        p.setP_key(property_key);

        Component e2 = new Component();
        e2.setComponent_type(component_type);

        Component e = new Component();
        e.setComponent_type("CALENDAR");
        e.setOwner(user_name);

        e.addProperty(p);
        e.addComponent(e2);

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
