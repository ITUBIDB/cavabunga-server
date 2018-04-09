package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.business.CalendarManagerService;
import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.http.ParameterResponse;
import edu.itu.cavabunga.core.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/parameter")
public class ParameterController {

    private CalendarManagerService calendarManagerService;

    @Autowired
    public ParameterController(CalendarManagerService calendarManagerService) {
        this.calendarManagerService = calendarManagerService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Response createParameter(@RequestParam(value = "parent_property_id") Long parentPropertyId,
                                    @RequestBody Parameter parameter) {
        calendarManagerService.addParameter(parameter,parentPropertyId);
        return new Response(0,"created");
    }

    @GetMapping("/{parameter_id}")
    @ResponseStatus(HttpStatus.OK)
    public ParameterResponse getParameter(@PathVariable(value = "parameter_id") Long parameterId) {
        return new ParameterResponse(0,null, calendarManagerService.getParameterById(parameterId));
    }

    @PutMapping("/{parameter_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response updateParameter(@PathVariable(value = "parameter_id") Long parameterId,
                                    @RequestBody Parameter parameter) {
        calendarManagerService.updateParameter(parameter, parameterId);
        return new Response(0,"updated");
    }

    @DeleteMapping("/{parameter_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteParameter(@PathVariable(value = "parameter_id") Long parameterId) {
        calendarManagerService.deleteParameter(parameterId);
        return new Response(0,"deleted");
    }
}
