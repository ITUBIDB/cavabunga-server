package tr.edu.itu.cavabunga.server.factory;

import org.springframework.stereotype.Component;
import tr.edu.itu.cavabunga.server.entity.ClientAuthorization;

@Component
public class ClientAuthorizationFactoryImpl implements ClientAuthorizationFactory {
    @Override
    public ClientAuthorization createClientAuthorization(){
        return new ClientAuthorization();
    }
}
