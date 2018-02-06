package edu.itu.cavabunga.core.services;

import edu.itu.cavabunga.core.entity.Participant;
import edu.itu.cavabunga.core.entity.participant.ParticipantType;

import java.util.List;

public interface ParticipantService {
    Participant createParticipant(String user_name, ParticipantType participantType);

    void saveParticipant(Participant participant);

    Participant getParticipantByUserName(String user_name);

    Participant getParticipantByUuid(String uuid);

    List<Participant> getAllParticipant();

    List<Participant> getAllParticipantByType(ParticipantType participantType);
}
