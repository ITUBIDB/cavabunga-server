package edu.itu.cavabunga.core.services;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import edu.itu.cavabunga.core.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ParticipantFactory participantFactory;

    @Override
    public Participant createParticipant(String user_name){
        Participant temp = participantFactory.createUser();
        temp.setUserName(user_name);
        participantRepository.save(temp);
        return temp;
    }

    @Override
    public void saveParticipant(Participant participant){
        participantRepository.save(participant);
    }

    @Override
    public Participant getParticipantByUserName(String user_name){
        return participantRepository.findByUserName(user_name);
    }

    @Override
    public Participant getParticipantByUuid(String uuid){
        return participantRepository.findByUuid(uuid);
    }
}
