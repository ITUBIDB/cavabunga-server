package tr.edu.itu.cavabunga.server.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import tr.edu.itu.cavabunga.server.auth.AuthenticatedClient;

public interface ClientAuthenticationService {
    @Bean
    @Scope("request")
    AuthenticatedClient authenticateClient();

    ClientAuthorizationService getClientAuthorizationService();

    ClientService getClientService();

    tr.edu.itu.cavabunga.server.factory.AuthenticatedClientFactory getAuthenticatedClientFactory();

    String getToken();

    void setClientAuthorizationService(ClientAuthorizationService clientAuthorizationService);

    void setClientService(ClientService clientService);

    void setAuthenticatedClientFactory(tr.edu.itu.cavabunga.server.factory.AuthenticatedClientFactory authenticatedClientFactory);

    void setToken(String token);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
