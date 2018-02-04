package edu.itu.cavabunga.core.controller;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.exception.ParticipantConflict;
import edu.itu.cavabunga.core.exception.ParticipantNotFound;
import edu.itu.cavabunga.core.services.IcalService;
import edu.itu.cavabunga.core.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            throw new ParticipantConflict(participant.getUserName() + " kullanici adi ile bir kullanici mevcut");
        }

        participantService.saveParticipant(participant);
        return new ResultResponse(0,"kullanici olusturuldu.", null);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResultResponse getAllParticipants(){
        List<Participant> participants = participantService.getAllParticipant();
        if(participants.isEmpty()){
            throw new ParticipantNotFound("sistemde kayıtlı kullanici yok");
        }

        return new ResultResponse(0,null,participants);
    }

    @GetMapping("/{userName}")
    @ResponseStatus(HttpStatus.OK)
    ResultResponse getParticipant(@PathVariable("userName") String userName){
        Participant participant = participantService.getParticipantByUserName(userName);
        if(participant == null){
            throw new ParticipantNotFound("kullanici bulunamdi " + userName);
        }

        return new ResultResponse(0,null,participant);
    }

    @PutMapping("/{userName}")
    @ResponseStatus(HttpStatus.OK)
    ResultResponse updateParticipant(@RequestBody Participant participant, @PathVariable("userName") String userName){
        Participant checkParticipant = participantService.getParticipantByUserName(userName);
        if(checkParticipant == null){
            throw new ParticipantNotFound(userName + " ile daha önceden oluşturulmuş bir kullanıcı mevcut degil");
        }

        participantService.saveParticipant(participant);
        return new ResultResponse(0,userName + " kullanici basari ile guncellendi", null);
    }

    @DeleteMapping("/{userName}")
    @ResponseStatus(HttpStatus.OK)
    ResultResponse deleteParticipant(@PathVariable("userName") String userName){
        Participant participant = participantService.getParticipantByUserName(userName);
        if(participant == null){
            throw new ParticipantNotFound(userName + " ile oluşturulmus bir kullanici bulunamadi");
        }

        return new ResultResponse(0,"kullanici basari ile silindi", null);
    }
}
