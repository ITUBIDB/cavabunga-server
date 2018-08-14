package tr.edu.itu.cavabunga.server.service;

import tr.edu.itu.cavabunga.server.entity.Client;
import tr.edu.itu.cavabunga.server.entity.ClientAuthorization;

import java.util.List;

public interface ClientAuthorizationService {
    ClientAuthorization createClientAuthorization();

    ClientAuthorization getClientAuthorizationById(Long id);

    List<ClientAuthorization> getAuthorzationsByClient(Client client);

    void saveClientAuthorization(ClientAuthorization clientAuthorization);

    void deleteClientAuthorizationById(Long id);

    void deleteClientAuthorization(ClientAuthorization clientAuthorization);

    void updateClientAuthorization(Long id, ClientAuthorization clientAuthorization);
}
