package tr.edu.itu.cavabunga.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.server.entity.ParticipantAuthorization;

import java.util.List;

@Repository
public interface ParticipantAuthorizationRepository extends JpaRepository<ParticipantAuthorization, Long> {
    ParticipantAuthorization findById(Long id);

    List<ParticipantAuthorization> findByParticipant(Participant participant);
}
