package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, String> {
    public Participant findByUserName(String name);

    public Participant findByUuid(String uuid);

}
