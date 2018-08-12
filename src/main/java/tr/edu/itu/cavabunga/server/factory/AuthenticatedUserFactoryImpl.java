package tr.edu.itu.cavabunga.server.factory;

import org.springframework.stereotype.Component;
import tr.edu.itu.cavabunga.server.auth.AuthenticatedUser;

@Component
public class AuthenticatedUserFactoryImpl implements AuthenticatedUserFactory {
    @Override
    public AuthenticatedUser createAuthenticatedUser(){
        return new AuthenticatedUser();
    }
}
