package tr.edu.itu.cavabunga.server.service;

import tr.edu.itu.cavabunga.server.entity.Client;

public interface ClientService {
    Client getClientById(Long id);

    Client getClientByAccessToken(String token);

    void saveClinet(Client client);

    void deleteClient(Client client);

    void deleteClientById(Long id);

    void updateClient(Long id, Client client);

    tr.edu.itu.cavabunga.server.factory.ClientFactory getClientFactory();

    tr.edu.itu.cavabunga.server.repository.ClientRepository getClientRepository();

    void setClientFactory(tr.edu.itu.cavabunga.server.factory.ClientFactory clientFactory);

    void setClientRepository(tr.edu.itu.cavabunga.server.repository.ClientRepository clientRepository);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
