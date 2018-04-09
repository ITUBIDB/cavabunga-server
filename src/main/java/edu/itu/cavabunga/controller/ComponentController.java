package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.business.CalendarManagerService;
import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.http.ComponentResponse;
import edu.itu.cavabunga.core.http.PropertyResponse;
import edu.itu.cavabunga.core.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/component")
public class ComponentController {

    private CalendarManagerService calendarManagerService;

    @Autowired
    public ComponentController(CalendarManagerService calendarManagerService) {
        this.calendarManagerService = calendarManagerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response createComponent(@RequestParam(value = "user_name") String userName,
                                    @RequestParam(value = "parent_component_id") Long ParentComponentId,
                                    Component component) {
        calendarManagerService.addComponent(component, userName, ParentComponentId);
        return new Response(0,"created");
    }

    @GetMapping("/{component_id}")
    @ResponseStatus(HttpStatus.OK)
    public ComponentResponse getComponent(@PathVariable(value = "component_id")Long componentId){
        return new ComponentResponse(0,null,calendarManagerService.getComponentById(componentId));
    }

    @PutMapping("/{component_id}/")
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateComponent(@PathVariable(value = "component_id")Long componentId,
                                    @RequestBody Component component) {
        calendarManagerService.updateComponent(componentId, component);
        return new Response(0,"updated");
    }

    @DeleteMapping("/{component_id}/")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteComponent(@PathVariable(value = "component_id")Long componentId) {
        calendarManagerService.deleteComponentById(componentId);
        return new Response(0,"deleted");
    }

    @GetMapping("/{component_id}/property")
    @ResponseStatus(HttpStatus.OK)
    public PropertyResponse getComponentProperties(@PathVariable(value = "component_id")Long componentId) {
        return new PropertyResponse(0,null,calendarManagerService.getPropertiesOfComponent(componentId));
    }
}
