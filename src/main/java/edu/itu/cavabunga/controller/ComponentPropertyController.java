package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.core.http.ComponentPropertyResponse;
import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.ComponentProperty;
import edu.itu.cavabunga.core.http.Response;
import edu.itu.cavabunga.core.services.ComponentPropertyService;
import edu.itu.cavabunga.core.services.IcalService;
import edu.itu.cavabunga.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calendarprop")
public class ComponentPropertyController {
    @Autowired
    IcalService icalService;

    @Autowired
    ComponentPropertyService componentPropertyService;

    @PostMapping("/{componentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response saveComponentProperty(@PathVariable("componentId") Long id, @RequestBody ComponentProperty componentProperty){
        Component checkComponent = icalService.getComponentById(id);
        if(checkComponent == null){
            throw new NotFound(id + "ile iliskilendirilmis bir bilesen bulunamadi");
        }

        componentProperty.setComponent(checkComponent);
        componentPropertyService.saveComponentProperty(componentProperty);
        return new Response(0,"Bilesen ozellikleri basari ile kaydedildi");
    }

    @GetMapping("/{componentId}")
    @ResponseStatus(HttpStatus.OK)
    public ComponentPropertyResponse getCalendarProperty(@PathVariable("componentId") Long id){
        Component checkComponent = icalService.getComponentById(id);
        if(checkComponent == null){
            throw new NotFound(id + "ile iliskilendirilmis bir bilesen bulunamadi");
        }

        ComponentProperty calendarProperties = componentPropertyService.getComponentPropertyByComponent(checkComponent);
        List<ComponentProperty> result = new ArrayList<ComponentProperty>();
        result.add(calendarProperties);
        return new ComponentPropertyResponse(0,null, result);
    }

    @DeleteMapping("/{componentId}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteCalendarProperty(@PathVariable("componentId") Long id){
        Component checkComponent = icalService.getComponentById(id);
        if(checkComponent == null){
            throw new NotFound(id + "ile iliskilendirilmis bir bilesen bulunamadi");
        }

        ComponentProperty checkProperty = componentPropertyService.getComponentPropertyByComponent(checkComponent);
        if(checkComponent == null){
            throw new NotFound(id + "ile iliskilendirilmis bir bilesen ozelligi bulunamadi");
        }

        componentPropertyService.deleteComponentProperty(checkProperty);
        return new Response(0,"basari ile silindi");
    }

    @PutMapping("/{componentId}")
    @ResponseStatus(HttpStatus.OK)
    public Response updateCalendarProperty(@PathVariable("componentId") Long id){
        Component checkComponent = icalService.getComponentById(id);
        if(checkComponent == null){
            throw new NotFound(id + "ile iliskilendirilmis bir bilesen bulunamadi");
        }

        ComponentProperty checkProperty = componentPropertyService.getComponentPropertyByComponent(checkComponent);
        if(checkComponent == null){
            throw new NotFound(id + "ile iliskilendirilmis bir bilesen ozelligi bulunamadi");
        }

        componentPropertyService.saveComponentProperty(checkProperty);
        return new Response(0,"basarı ile guncellendi");
    }

}
