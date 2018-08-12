package tr.edu.itu.cavabunga.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.server.entity.ParticipantAuthorization;
import tr.edu.itu.cavabunga.server.factory.ParticipantAuthorizationFactory;
import tr.edu.itu.cavabunga.server.repository.ParticipantAuthorizationRepository;

import java.util.List;

@Service
public class ParticipantAuthorizationServiceImpl implements ParticipantAuthorizationService {
    public ParticipantAuthorizationFactory participantAuthorizationFactory;
    public ParticipantAuthorizationRepository participantAuthorizationRepository;

    @Autowired
    public ParticipantAuthorizationServiceImpl(ParticipantAuthorizationFactory participantAuthorizationFactory, ParticipantAuthorizationRepository participantAuthorizationRepository){
        this.participantAuthorizationFactory = participantAuthorizationFactory;
        this.participantAuthorizationRepository = participantAuthorizationRepository;
    }

    @Override
    public ParticipantAuthorization createParticipantAuthorization(){
        return participantAuthorizationFactory.createParticipantAuthorization();
    }

    @Override
    public ParticipantAuthorization getParticipantAuthorizationById(Long id){
        return participantAuthorizationRepository.findById(id);
    }

    @Override
    public List<ParticipantAuthorization> getParticipantAuthorizationByParticipant(Participant participant){
        return participantAuthorizationRepository.findByParticipant(participant);
    }

    @Override
    public void saveParticipantAuthorization(ParticipantAuthorization participantAuthorization){
        participantAuthorizationRepository.save(participantAuthorization);
    }

    @Override
    public void deletParticipantAuthorizationById(Long id){
        participantAuthorizationRepository.delete(id);
    }

    @Override
    public void deleteParticipantAuthorization(ParticipantAuthorization participantAuthorization){
        participantAuthorizationRepository.delete(participantAuthorization);
    }

    @Override
    public void updateParticipantAuthorization(Long id, ParticipantAuthorization participantAuthorization){
        participantAuthorization.setId(id);
        participantAuthorizationRepository.save(participantAuthorization);
    }
}
