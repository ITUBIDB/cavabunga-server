package tr.edu.itu.cavabunga.server.factory;

import org.springframework.stereotype.Component;
import tr.edu.itu.cavabunga.server.auth.AuthenticatedClient;

@Component
public class AuthenticatedClientFactoryImpl implements AuthenticatedClientFactory {
    @Override
    public AuthenticatedClient createAuthenticatedClient(){
        return new AuthenticatedClient();
    }
}
