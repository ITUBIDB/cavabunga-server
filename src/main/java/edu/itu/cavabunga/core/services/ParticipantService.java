package edu.itu.cavabunga.core.services;

import edu.itu.cavabunga.core.entity.Participant;

import java.util.List;

public interface ParticipantService {
    Participant createParticipant(String user_name);

    void saveParticipant(Participant participant);

    Participant getParticipantByUserName(String user_name);

    Participant getParticipantByUuid(String uuid);

    List<Participant> getAllParticipant();
}
