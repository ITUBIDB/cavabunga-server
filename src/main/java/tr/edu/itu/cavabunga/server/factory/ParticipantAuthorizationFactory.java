package tr.edu.itu.cavabunga.server.factory;

import org.springframework.stereotype.Component;
import tr.edu.itu.cavabunga.server.entity.ParticipantAuthorization;

@Component
public interface ParticipantAuthorizationFactory {
    ParticipantAuthorization createParticipantAuthorization();
}
