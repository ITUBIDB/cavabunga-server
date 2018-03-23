package edu.itu.cavabunga.core.services;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;
import edu.itu.cavabunga.core.factory.ParticipantFactory;
import edu.itu.cavabunga.core.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ParticipantFactory participantFactory;

    @Override
    public Participant createParticipant(String userName, ParticipantType participantType){
        Participant newParticipant = participantFactory.createParticipant(participantType);
        newParticipant.setUserName(userName);
        participantRepository.save(newParticipant);
        return newParticipant;
    }

    @Override
    public void saveParticipant(Participant participant){
        participantRepository.save(participant);
    }

    @Override
    public Optional<Participant> getParticipantByUserName(String user_name){
        return participantRepository.findByUserName(user_name);
    }

    @Override
    public Optional<Participant> getParticipantById(Long id){
        return participantRepository.findById(id);
    }

    @Override
    public List<Participant> getAllParticipant(){
        return participantRepository.findAll();
    }

    @Override
    public void deleteParticipantById(Long id){
        participantRepository.delete(id);
    }
}
