package edu.itu.cavabunga.core.controller;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.exception.ParticipantConflictException;
import edu.itu.cavabunga.core.services.IcalService;
import edu.itu.cavabunga.core.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/participant")
public class ParticipantController {
    @Autowired
    IcalService icalService;

    @Autowired
    ParticipantService participantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResultResponse saveParticipant(@RequestBody Participant participant){
        Participant checkParticipant = participantService.getParticipantByUserName(participant.getUserName());
        if(checkParticipant != null){
            throw new ParticipantConflictException(participant.getUserName() + " kullanici adi ile bir kullanici mevcut")
        }

        participantService.saveParticipant(participant);
        return new ResultResponse(0,"kullanici olusturuldu.", null);
    }

    
}
