package edu.itu.cavabunga.controller;

import edu.itu.cavabunga.business.CalendarManagerService;
import edu.itu.cavabunga.core.http.ParticipantResponse;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/participant")
public class ParticipantController {
   private CalendarManagerService calendarManagerService;

    @Autowired
    public ParticipantController(CalendarManagerService calendarManagerService) {
        this.calendarManagerService = calendarManagerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ParticipantResponse getAllParticipants(){
        return new ParticipantResponse(0,null, calendarManagerService.getAllParticipants());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response newParticipant(@RequestBody Participant participant){
        calendarManagerService.addParticipant(participant);
        return new Response(0,"created");
    }

    @GetMapping("/{user_name}")
    @ResponseStatus(HttpStatus.OK)
    public ParticipantResponse getParticipant(@PathVariable(value = "user_name") String userName){
        return new ParticipantResponse(0,null,calendarManagerService.getParticipantByUserName(userName));
    }

    @DeleteMapping("/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteParticipant(@PathVariable(value = "user_id") Long id){
       calendarManagerService.deleteParticipantById(id);
       return new Response(0,"deleted");
    }

    @PutMapping("/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public Response updateParticipant(@PathVariable(value = "user_id") Long id, @RequestBody Participant participant){
       calendarManagerService.updateParticipant(id, participant);
       return new Response(0,"updated");
    }
}
