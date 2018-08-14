package tr.edu.itu.cavabunga.server.factory;

import org.springframework.stereotype.Component;
import tr.edu.itu.cavabunga.server.entity.Client;

@Component
public class ClientFactoryImpl implements ClientFactory {
    @Override
    public Client createClient(){
        return new Client();
    }
}
