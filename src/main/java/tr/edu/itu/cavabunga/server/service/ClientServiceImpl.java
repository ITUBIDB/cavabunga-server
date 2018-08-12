package tr.edu.itu.cavabunga.server.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.itu.cavabunga.server.entity.Client;
import tr.edu.itu.cavabunga.server.factory.ClientFactory;
import tr.edu.itu.cavabunga.server.repository.ClientRepository;

@Data
@Service
public class ClientServiceImpl implements ClientService {
    private ClientFactory clientFactory;
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientFactory clientFactory, ClientRepository clientRepository){
        this.clientFactory = clientFactory;
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientById(Long id){
        return clientRepository.findById(id);
    }

    @Override
    public Client getClientByAccessToken(String token){
        return clientRepository.findByAccessToken(token);
    }

    @Override
    public void saveClinet(Client client){
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client){
        clientRepository.delete(client);
    }

    @Override
    public void deleteClientById(Long id){
        clientRepository.delete(id);
    }

    @Override
    public void updateClient(Long id, Client client){
        client.setId(id);
        clientRepository.save(client);
    }
}
