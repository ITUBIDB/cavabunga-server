package tr.edu.itu.cavabunga.server.factory;

import org.springframework.stereotype.Component;
import tr.edu.itu.cavabunga.server.entity.ClientAuthorization;

@Component
public interface ClientAuthorizationFactory {
    ClientAuthorization createClientAuthorization();
}
