package edu.itu.cavabunga.core.service;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    Participant createParticipant(String user_name, ParticipantType participantType);

    void saveParticipant(Participant participant);

    Optional<Participant> getParticipantByUserName(String user_name);

    Optional<Participant> getParticipantById(Long id);

    List<Participant> getAllParticipant();

    void deleteParticipantById(Long id);
}
