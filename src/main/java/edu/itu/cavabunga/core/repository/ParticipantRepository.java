package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ParticipantRepository extends JpaRepository<Participant, String> {
    Participant findByUserName(String name);

    Participant findByUuid(String uuid);

    @Query("select a from Participant a where type=?1")
    List<Participant> findByType(String type);
}
