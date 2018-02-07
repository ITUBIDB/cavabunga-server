package edu.itu.cavabunga.core.controller;

import edu.itu.cavabunga.core.controller.wrapper.ParticipantPropertyResponse;
import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.ParticipantProperty;
import edu.itu.cavabunga.core.exception.ParticipantNotFound;
import edu.itu.cavabunga.core.exception.ParticipantPropertyNotFound;
import edu.itu.cavabunga.core.services.ParticipantPropertyService;
import edu.itu.cavabunga.core.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/participantprop")
public class ParticipantPropertyController {
    @Autowired
    private ParticipantPropertyService participantPropertyService;

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/{participantUuid}")
    @ResponseStatus(HttpStatus.OK)
    public ParticipantPropertyResponse getParticipantProperty(@PathVariable(value = "participantUuid") String uuid){
        Participant checkParticipant = participantService.getParticipantByUuid(uuid);
        if(checkParticipant == null){
            throw new ParticipantNotFound(uuid + "ile eslestirilen bir kullanici bulunamdi");
        }

        ParticipantProperty checkParticipantProperty = participantPropertyService.getParticipantPropertyByParticipant(checkParticipant);
        if(checkParticipantProperty == null){
            throw new ParticipantPropertyNotFound(uuid + "ile eslestirilmis kullanici icin bir ozellik bulunamadi");
        }

        List<ParticipantProperty> result = new ArrayList<ParticipantProperty>();
        result.add(checkParticipantProperty);
        return new ParticipantPropertyResponse(0,null,result);
    }

    @PostMapping("/{participantUuid}")
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipantPropertyResponse saveParticipantProperty(@PathVariable(value = "participantUuid") String uuid, @RequestBody ParticipantProperty participantProperty){
        Participant checkParticipant = participantService.getParticipantByUuid(uuid);
        if(checkParticipant == null){
            throw new ParticipantNotFound(uuid + "ile eslestirilmis kullanici icin bir ozellik bulunamadi");
        }

        participantPropertyService.saveParticipantProperty(participantProperty);
        return new ParticipantPropertyResponse(0,"basari ile kaydedildi",null);
    }

    @DeleteMapping("/{participantUuid}")
    @ResponseStatus(HttpStatus.OK)
    public ParticipantPropertyResponse deleteParticipantProperty(@PathVariable(value = "participantUuid") String uuid){
        Participant checkParticipant = participantService.getParticipantByUuid(uuid);
        if(checkParticipant == null){
            throw new ParticipantNotFound(uuid + "ile eslestirilmis kullanici icin bir ozellik bulunamadi");
        }

        ParticipantProperty checkParticipantProperty = participantPropertyService.getParticipantPropertyByParticipant(checkParticipant);
        if(checkParticipantProperty == null){
            throw new ParticipantPropertyNotFound(uuid + "ile eslestirilmis kullanici icin bir ozellik bulunamadi");
        }

        participantPropertyService.deleteParticipantProperty(checkParticipantProperty);
        return new ParticipantPropertyResponse(0,"basari ile silindi", null);
    }

}
