package tr.edu.itu.cavabunga.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.itu.cavabunga.server.entity.Client;
import tr.edu.itu.cavabunga.server.entity.ClientAuthorization;
import tr.edu.itu.cavabunga.server.factory.ClientAuthorizationFactory;
import tr.edu.itu.cavabunga.server.factory.ClientFactory;
import tr.edu.itu.cavabunga.server.repository.ClientAuthorizationRepository;

import java.util.List;

@Service
public class ClientAuthorizationServiceImpl implements ClientAuthorizationService {
    public ClientAuthorizationFactory clientAuthorizationFactory;
    public ClientAuthorizationRepository clientAuthorizationRepository;

    @Autowired
    public ClientAuthorizationServiceImpl(ClientAuthorizationFactory clientAuthorizationFactory, ClientAuthorizationRepository clientAuthorizationRepository){
        this.clientAuthorizationFactory = clientAuthorizationFactory;
        this.clientAuthorizationRepository = clientAuthorizationRepository;
    }

    @Override
    public ClientAuthorization createClientAuthorization(){
        return clientAuthorizationFactory.createClientAuthorization();
    }

    @Override
    public ClientAuthorization getClientAuthorizationById(Long id){
        return clientAuthorizationRepository.findById(id);
    }

    @Override
    public List<ClientAuthorization> getAuthorzationsByClient(Client client){
        return clientAuthorizationRepository.findByClient(client);
    }

    @Override
    public void saveClientAuthorization(ClientAuthorization clientAuthorization){
        clientAuthorizationRepository.save(clientAuthorization);
    }

    @Override
    public void deleteClientAuthorizationById(Long id){
        clientAuthorizationRepository.delete(id);
    }

    @Override
    public void deleteClientAuthorization(ClientAuthorization clientAuthorization){
        clientAuthorizationRepository.delete(clientAuthorization);
    }

    @Override
    public void updateClientAuthorization(Long id, ClientAuthorization clientAuthorization){
        clientAuthorization.setId(id);
        clientAuthorizationRepository.save(clientAuthorization);
    }
}
