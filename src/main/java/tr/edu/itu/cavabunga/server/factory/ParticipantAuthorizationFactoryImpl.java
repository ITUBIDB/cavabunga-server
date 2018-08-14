package tr.edu.itu.cavabunga.server.factory;

import org.springframework.stereotype.Component;
import tr.edu.itu.cavabunga.server.entity.ParticipantAuthorization;

@Component
public class ParticipantAuthorizationFactoryImpl implements ParticipantAuthorizationFactory {
    @Override
    public ParticipantAuthorization createParticipantAuthorization(){
        return new ParticipantAuthorization();
    }
}
