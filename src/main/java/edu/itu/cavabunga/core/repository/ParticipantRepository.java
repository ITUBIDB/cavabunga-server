package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ParticipantRepository extends CrudRepository<Participant, String> {
    Participant findByUserName(String name);

    Participant findByUuid(String uuid);

}
