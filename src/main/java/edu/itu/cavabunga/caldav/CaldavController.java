package edu.itu.cavabunga.caldav;

import edu.itu.cavabunga.core.IcalStorageService;
import edu.itu.cavabunga.core.ParticipantStorageService;
import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/calendar")
public class CaldavController {
    @Autowired
    private IcalStorageService icalStorageService;

    @Autowired
    private ParticipantStorageService participantStorageService;

    @GetMapping(path="/participant/u")
    public @ResponseBody Participant getParticipantByUserName(@RequestParam String user_name){
        return participantStorageService.getParticipantByUserName(user_name);
    }

    @GetMapping(path="/participant/i")
    public @ResponseBody Participant getParticipantById(@RequestParam String uuid){
        return participantStorageService.getParticipantByUuid(uuid);
    }


}
