package tr.edu.itu.cavabunga.server.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import tr.edu.itu.cavabunga.server.auth.AuthenticatedClient;
import tr.edu.itu.cavabunga.server.entity.Client;
import tr.edu.itu.cavabunga.server.entity.ClientAuthorization;
import tr.edu.itu.cavabunga.server.exception.AuthenticationException;
import tr.edu.itu.cavabunga.server.exception.AuthorizationException;
import tr.edu.itu.cavabunga.server.factory.AuthenticatedClientFactory;

import java.util.List;

@Service
@Data
public class ClientAuthenticationServiceImpl implements ClientAuthenticationService {
    private ClientAuthorizationService clientAuthorizationService;
    private ClientService clientService;
    private AuthenticatedClientFactory authenticatedClientFactory;
    private String token;

    @Autowired
    public ClientAuthenticationServiceImpl(ClientAuthorizationService clientAuthorizationService,
                                           ClientService clientService,
                                           AuthenticatedClientFactory authenticatedClientFactory){
        this.clientAuthorizationService = clientAuthorizationService;
        this.clientService = clientService;
        this.authenticatedClientFactory = authenticatedClientFactory;
    }

    @Override
    @Bean
    @Scope("request")
    public AuthenticatedClient authenticateClient(){
        AuthenticatedClient authenticatedClient = authenticatedClientFactory.createAuthenticatedClient();
        Client client;
        List<ClientAuthorization> clientAuthorizations;

        try {
            client = clientService.getClientByAccessToken(token);
        }catch (Exception e){
            throw new AuthenticationException("Client cannot authenticated with token: " + token);
        }

         try {
             clientAuthorizations = clientAuthorizationService.getAuthorzationsByClient(client);
         }catch (Exception e){
             throw new AuthorizationException("Cannot authorize the client with token: " + token);
         }

         authenticatedClient.setClient(client);
         for(ClientAuthorization authorization: clientAuthorizations){
             authenticatedClient.addPermission(authorization.getPermission());
         }

         return authenticatedClient;
    }


}
