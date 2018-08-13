package tr.edu.itu.cavabunga.server.auth;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import tr.edu.itu.cavabunga.server.entity.Client;
import tr.edu.itu.cavabunga.server.entity.ClientAuthorization;
import tr.edu.itu.cavabunga.server.entity.ClientPermissionEnum;

import java.util.List;

@Component

@Data
public class AuthenticatedClient {
    private Client client;

    private List<ClientPermissionEnum> permissions;

    public void addPermission(ClientPermissionEnum clientPermissionEnum){
        this.permissions.add(clientPermissionEnum);
    }

    public void removePermission(ClientPermissionEnum clientPermissionEnum){
        this.permissions.remove(clientPermissionEnum);
    }
}
