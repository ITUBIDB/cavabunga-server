package edu.itu.cavabunga.core;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import edu.itu.cavabunga.core.factory.TimeFactory;
import edu.itu.cavabunga.core.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantStorageService {
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ParticipantFactory participantFactory;

    public Participant createParticipant(String user_name){
        Participant temp = participantFactory.createUser(user_name);
        participantRepository.save(temp);
        return temp;
    }

    public void saveParticipant(Participant participant){
        participantRepository.save(participant);
    }

    public Participant getParticipantByUserName(String user_name){
        return participantRepository.findByUserName(user_name);
    }

    public Participant getParticipantByUuid(String uuid){
        return participantRepository.findByUuid(uuid);
    }
}
