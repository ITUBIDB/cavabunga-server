package tr.edu.itu.cavabunga.server.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import tr.edu.itu.cavabunga.server.auth.AuthenticatedUser;

public interface ParticipantAuthenticationService {
    @Bean
    @Scope("request")
    AuthenticatedUser authenticateUser();

    ParticipantAuthorizationService getParticipantAuthorizationService();

    ParticipantService getParticipantService();

    tr.edu.itu.cavabunga.server.factory.AuthenticatedUserFactory getAuthenticatedUserFactory();

    String getUserName();

    String getPassword();

    void setParticipantAuthorizationService(ParticipantAuthorizationService participantAuthorizationService);

    void setParticipantService(ParticipantService participantService);

    void setAuthenticatedUserFactory(tr.edu.itu.cavabunga.server.factory.AuthenticatedUserFactory authenticatedUserFactory);

    void setUserName(String userName);

    void setPassword(String password);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
