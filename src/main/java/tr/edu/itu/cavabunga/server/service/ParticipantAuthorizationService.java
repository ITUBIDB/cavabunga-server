package tr.edu.itu.cavabunga.server.service;

import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.server.entity.ParticipantAuthorization;

import java.util.List;

public interface ParticipantAuthorizationService {
    ParticipantAuthorization createParticipantAuthorization();

    ParticipantAuthorization getParticipantAuthorizationById(Long id);

    List<ParticipantAuthorization> getParticipantAuthorizationByParticipant(Participant participant);

    void saveParticipantAuthorization(ParticipantAuthorization participantAuthorization);

    void deletParticipantAuthorizationById(Long id);

    void deleteParticipantAuthorization(ParticipantAuthorization participantAuthorization);

    void updateParticipantAuthorization(Long id, ParticipantAuthorization participantAuthorization);
}
