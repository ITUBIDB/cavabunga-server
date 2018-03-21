package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.business.CalendarManagerService;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.parameter.ParameterType;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;
import edu.itu.cavabunga.core.entity.property.PropertyType;
import edu.itu.cavabunga.core.http.ComponentResponse;
import edu.itu.cavabunga.core.http.ParameterResponse;
import edu.itu.cavabunga.core.http.PropertyResponse;
import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import edu.itu.cavabunga.core.entity.component.ComponentType;
import edu.itu.cavabunga.core.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/participant")
public class CalendarController {
    @Autowired
    private CalendarManagerService calendarManagerService;

    @GetMapping(path = "/testcalendarcreate")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String test(){
        Participant celikd = calendarManagerService.createParticipant("celikd", ParticipantType.User);
        Participant sdg = calendarManagerService.createParticipant("sdg", ParticipantType.Group);
        calendarManagerService.saveParticipant(celikd);
        calendarManagerService.saveParticipant(sdg);


        Component calendar = calendarManagerService.createComponentForParticipant(ComponentType.Calendar, "celikd");
        Component event = calendarManagerService.createComponent(ComponentType.Event);
        Component alarm = calendarManagerService.createComponent(ComponentType.Alarm);

        Property uid = calendarManagerService.createProperty(PropertyType.Uid);
        uid.setValue("23734BC-AD123DEF-CC-D123");

        Property calscale = calendarManagerService.createProperty(PropertyType.Calscale);
        calscale.setValue("GREGORIAN");

        Property dtsamp = calendarManagerService.createProperty(PropertyType.Dtstamp);
        dtsamp.setValue("160620018092822 UTC+3");

        Property attach = calendarManagerService.createProperty(PropertyType.Attach);
        attach.setValue("A FILE");

        Parameter encoding = calendarManagerService.createParameter(ParameterType.Encoding);
        encoding.setValue("UTF-8");


        event.setOwner(celikd);
        alarm.setOwner(celikd);
        calendar.setOwner(celikd);

        attach.addParameter(encoding);
        event.addProperty(attach);
        event.addProperty(dtsamp);
        event.addComponent(alarm);


        calendar.addComponent(event);
        calendar.addProperty(uid);
        calendar.addProperty(calscale);



        calendarManagerService.saveComponent(calendar);


        return "ok";
    }

    @PostMapping("/{user_key}/calendar")
    @ResponseStatus(HttpStatus.CREATED)
    public Response newCalendarForParticipant(@PathVariable(value = "user_key") String userName, @RequestBody Component component){
        calendarManagerService.addComponent(component,userName,null);
        return new Response(0,"created");
    }

    @GetMapping("/{user_key}/calendar")
    @ResponseStatus(HttpStatus.OK)
    public ComponentResponse getParticipantCalendars(@PathVariable(value = "user_key") String userName){
        return new ComponentResponse(0,null, calendarManagerService.getComponentsByParticipantAndType(userName, ComponentType.Calendar));
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/")
    @ResponseStatus(HttpStatus.OK)
    public ComponentResponse getParticipantCalendar(@PathVariable(value = "user_key") String userName , @PathVariable(value = "calendar_id") Long id){
        return new ComponentResponse(0,null, calendarManagerService.getComponentById(id));
    }

    @PutMapping("/{user_key}/calendar/{calendar_id}/")
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateParticipantCalendar(@PathVariable(value = "user_key") String userName, @PathVariable(value = "calendar_id") Long id, @RequestBody Component component){
        calendarManagerService.updateComponent(id,component);
        return new Response(0,"updated");
    }

    @DeleteMapping("/{user_key}/calendar/{calendar_id}/")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteParticipantCalendar(@PathVariable(value = "user_key") String userName, @PathVariable(value = "calendar_id") Long id){
        calendarManagerService.deleteComponentById(id);
        return new Response(0,"deleted");
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/property")
    @ResponseStatus(HttpStatus.OK)
    public PropertyResponse getParticipantCalendarProperties(@PathVariable(value = "user_key") String userName, @PathVariable(value = "calendar_id")Long id){
        return new PropertyResponse(0,null,calendarManagerService.getPropertyForComponent(id));
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/property/{property_id}")
    @ResponseStatus(HttpStatus.OK)
    public PropertyResponse getParticipantCalendarProperty(@PathVariable(value = "user_key") String userName,
                                                             @PathVariable(value = "calendar_id")Long id,
                                                             @PathVariable(value = "property_id") Long propertyId){
        return new PropertyResponse(0,null,calendarManagerService.getPropertyById(propertyId));
    }

    @PostMapping("/{user_key}/calendar/{calendar_id}/property")
    @ResponseStatus(HttpStatus.CREATED)
    public Response newParticipantCalendarProperty(@PathVariable(value = "user_key") String userName, @PathVariable(value = "calendar_id") Long id, @RequestBody Property property){
        calendarManagerService.addProperty(property, userName, id);
        return new Response(0,"created");
    }

    @PutMapping("/{user_key}/calendar/{calendar_id}/property/{property_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateParticipantCalendarProperty(@PathVariable(value = "user_key") String userName,
                                                              @PathVariable(value = "calendar_id") Long id,
                                                              @PathVariable(value = "property_id") Long propertyId,
                                                              @RequestBody Property property){
        calendarManagerService.updateProperty(propertyId,property);
        return new Response(0,"updated");
    }

    @DeleteMapping("/{user_key}/calendar/{calendar_id}/property/{property_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteParticipantCalendarProperty(@PathVariable(value = "user_key") String userName,
                                                              @PathVariable(value = "calendar_id") Long id,
                                                              @PathVariable(value = "property_id") Long propertyId){
        calendarManagerService.deleteProperty(propertyId);
        return new Response(0,"deleted");
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/{component_type}")
    @ResponseStatus(HttpStatus.OK)
    public ComponentResponse getParticipantCalendarComponents(@PathVariable(value = "user_key") String userName,
                                                             @PathVariable(value = "calendar_id") Long id,
                                                             @PathVariable(value = "component_type") String componentType){
        return new ComponentResponse(0,null, calendarManagerService.getComponentsByParticipantAndType(userName,ComponentType.valueOf(Character.toUpperCase(componentType.charAt(0)) + componentType.substring(1))));
    }

    @PostMapping("/{user_key}/calendar/{calendar_id}/{component_type}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response newParticipantCalendarComponent(@PathVariable(value = "user_key") String userName,
                                                             @PathVariable(value = "calendar_id") Long id,
                                                             @PathVariable(value = "component_type") String componentType, Component component){
        calendarManagerService.addComponent(component,userName,id);
        return new Response(0,"updated");
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}")
    @ResponseStatus(HttpStatus.OK)
    public ComponentResponse getParticipantCalendarComponent(@PathVariable(value = "user_key") String userName,
                                                             @PathVariable(value = "calendar_id") Long calendarId,
                                                             @PathVariable(value = "component_type") String componentType,
                                                             @PathVariable(value = "component_id") Long componentId){
        return new ComponentResponse(0,null,calendarManagerService.getComponentById(componentId));
    }

    @PostMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response newParticipantCalendarSubComponent(@PathVariable(value = "user_key") String userName,
                                                                @PathVariable(value = "calendar_id") Long calendarId,
                                                                @PathVariable(value = "component_type") String componentType,
                                                                @PathVariable(value = "component_id") Long componentId,
                                                                @RequestBody Component component){
        calendarManagerService.addComponent(component,userName,componentId);
        return new Response(0,"added");
    }

    @PutMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateParticipantCalendarComponent(@PathVariable(value = "user_key") String userName,
                                                             @PathVariable(value = "calendar_id") Long calendarId,
                                                             @PathVariable(value = "component_type") String componentType,
                                                             @PathVariable(value = "component_id") Long componentId,
                                                             @RequestBody Component component){
        calendarManagerService.updateComponent(componentId, component);
        return new Response(0,"update");
    }

    @DeleteMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response deleteParticipantCalendarComponent(@PathVariable(value = "user_key") String userName,
                                                             @PathVariable(value = "calendar_id") Long calendarId,
                                                             @PathVariable(value = "component_type") String componentType,
                                                             @PathVariable(value = "component_id") Long componentId){
        calendarManagerService.deleteComponentById(componentId);
        return new Response(0,"deleted");
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property")
    @ResponseStatus(HttpStatus.OK)
    public PropertyResponse getParticipantCalendarComponentProperties(@PathVariable(value = "user_key") String userName,
                                                                    @PathVariable(value = "calendar_id") Long calendarId,
                                                                    @PathVariable(value = "component_type") String componentType,
                                                                    @PathVariable(value = "component_id") Long componentId){
        return new PropertyResponse(0,null, calendarManagerService.getPropertyForComponent(componentId));
    }

    @PostMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property")
    @ResponseStatus(HttpStatus.CREATED)
    public Response newParticipantCalendarComponentProperty(@PathVariable(value = "user_key") String userName,
                                                                    @PathVariable(value = "calendar_id") Long calendarId,
                                                                    @PathVariable(value = "component_type") String componentType,
                                                                    @PathVariable(value = "component_id") Long componentId,
                                                                    @RequestBody Property property){
        calendarManagerService.addProperty(property,userName,componentId);
        return new Response(0,"created");
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property/{property_key}")
    @ResponseStatus(HttpStatus.OK)
    public PropertyResponse getParticipantCalendarComponentProperty(@PathVariable(value = "user_key") String userName,
                                                                    @PathVariable(value = "calendar_id") Long calendarId,
                                                                    @PathVariable(value = "component_type") String componentType,
                                                                    @PathVariable(value = "component_id") Long componentId,
                                                                    @PathVariable(value = "property_key") Long propertyId){
        return new PropertyResponse(0,null,calendarManagerService.getPropertyById(propertyId));
    }

    @PutMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property/{property_key}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateParticipantCalendarComponentProperty(@PathVariable(value = "user_key") String userName,
                                                                    @PathVariable(value = "calendar_id") Long calendarId,
                                                                    @PathVariable(value = "component_type") String componentType,
                                                                    @PathVariable(value = "component_id") Long componentId,
                                                                    @PathVariable(value = "property_key") Long propertyId,
                                                                       @RequestBody Property property){
        calendarManagerService.updateProperty(propertyId,property);
        return new Response(0,"update");
    }

    @DeleteMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property/{property_key}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteParticipantCalendarComponentProperty(@PathVariable(value = "user_key") String userName,
                                                                    @PathVariable(value = "calendar_id") Long calendarId,
                                                                    @PathVariable(value = "component_type") String componentType,
                                                                    @PathVariable(value = "component_id") Long componentId,
                                                                    @PathVariable(value = "property_key") Long propertyId){
        calendarManagerService.deleteComponentById(propertyId);
        return new Response(0,"delete");
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property/{property_key}/parameter")
    @ResponseStatus(HttpStatus.OK)
    public ParameterResponse getParticipantCalendarComponentPropertyParameters(@PathVariable(value = "user_key") String userName,
                                                                              @PathVariable(value = "calendar_id") Long calendarId,
                                                                              @PathVariable(value = "component_type") String componentType,
                                                                              @PathVariable(value = "component_id") Long componentId,
                                                                              @PathVariable(value = "property_key") Long propertyId){
        return new ParameterResponse(0,null, calendarManagerService.getParametersByProperty(propertyId));
    }

    @PostMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property/{property_key}/parameter")
    @ResponseStatus(HttpStatus.CREATED)
    public Response newParticipantCalendarComponentPropertyParameter(@PathVariable(value = "user_key") String userName,
                                                                              @PathVariable(value = "calendar_id") Long calendarId,
                                                                              @PathVariable(value = "component_type") String componentType,
                                                                              @PathVariable(value = "component_id") Long componentId,
                                                                              @PathVariable(value = "property_key") Long propertyId,
                                                                              @RequestBody Parameter parameter){
        calendarManagerService.addParameter(parameter,userName,componentId,propertyId);
        return new Response(0,"created");
    }

    @GetMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property/{property_key}/parameter/{parameter_key}")
    @ResponseStatus(HttpStatus.OK)
    public ParameterResponse getParticipantCalendarComponentPropertyParameter(@PathVariable(value = "user_key") String userName,
                                                                               @PathVariable(value = "calendar_id") Long calendarId,
                                                                               @PathVariable(value = "component_type") String componentType,
                                                                               @PathVariable(value = "component_id") Long componentId,
                                                                               @PathVariable(value = "property_key") Long propertyId,
                                                                               @PathVariable(value = "parameter_key") Long parameterId){
        return new ParameterResponse(0,null, calendarManagerService.getParameterById(parameterId));
    }

    @PutMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property/{property_key}/parameter/{parameter_key}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateParticipantCalendarComponentPropertyParameter(@PathVariable(value = "user_key") String userName,
                                                                              @PathVariable(value = "calendar_id") Long calendarId,
                                                                              @PathVariable(value = "component_type") String componentType,
                                                                              @PathVariable(value = "component_id") Long componentId,
                                                                              @PathVariable(value = "property_key") Long propertyId,
                                                                              @PathVariable(value = "parameter_key") Long parameterId,
                                                                                 @RequestBody Parameter parameter){
        calendarManagerService.updateParameter(parameter, parameterId);
        return new Response(0,"updated");
    }

    @DeleteMapping("/{user_key}/calendar/{calendar_id}/{component_type}/{component_id}/property/{property_key}/parameter/{parameter_key}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteParticipantCalendarComponentPropertyParameter(@PathVariable(value = "user_key") String userName,
                                                                              @PathVariable(value = "calendar_id") Long calendarId,
                                                                              @PathVariable(value = "component_type") String componentType,
                                                                              @PathVariable(value = "component_id") Long componentId,
                                                                              @PathVariable(value = "property_key") Long propertyId,
                                                                              @PathVariable(value = "parameter_key") Long parameterId){
        calendarManagerService.deleteParameter(parameterId);
        return new Response(0,"deleted");
    }
}