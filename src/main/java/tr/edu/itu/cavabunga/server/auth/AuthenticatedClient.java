package tr.edu.itu.cavabunga.server.auth;

import lombok.Data;
import tr.edu.itu.cavabunga.server.entity.Client;
import tr.edu.itu.cavabunga.server.entity.ClientPermissionEnum;

import java.util.List;

@Data
public class AuthenticatedClient {
    private Client client;

    private List<ClientPermissionEnum> permissions;
}
