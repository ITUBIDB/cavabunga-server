package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.business.CalendarManagerService;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.http.ParameterResponse;
import edu.itu.cavabunga.core.http.PropertyResponse;
import edu.itu.cavabunga.core.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/property")
public class PropertyController {

    private CalendarManagerService calendarManagerService;

    @Autowired
    public PropertyController(CalendarManagerService calendarManagerService) {
        this.calendarManagerService = calendarManagerService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Response createProperty(@RequestParam(value = "parent_component_id") Long parentComponentId,
                                   @RequestBody Property property) {
        calendarManagerService.addProperty(property, parentComponentId);
        return new Response(0,"created");
    }

    @GetMapping("/{property_id}")
    @ResponseStatus(HttpStatus.OK)
    public PropertyResponse getProperty(@PathVariable(value = "property_id") Long propertyId) {
        return new PropertyResponse(0,null,calendarManagerService.getPropertyById(propertyId));
    }

    @PutMapping("/{property_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateProperty(@PathVariable(value = "property_id") Long propertyId,
                                   @RequestBody Property property) {
        calendarManagerService.updateProperty(propertyId,property);
        return new Response(0,"updated");
    }

    @DeleteMapping("/{property_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteProperty(@PathVariable(value = "property_id") Long propertyId) {
        calendarManagerService.deleteProperty(propertyId);
        return new Response(0,"deleted");
    }

    @GetMapping("/{property_id}/parameter")
    @ResponseStatus(HttpStatus.OK)
    public ParameterResponse getPropertyParameters(@PathVariable(value = "property_id") Long propertyId){
        return new ParameterResponse(0,null, calendarManagerService.getParametersOfProperty(propertyId));
    }

}
