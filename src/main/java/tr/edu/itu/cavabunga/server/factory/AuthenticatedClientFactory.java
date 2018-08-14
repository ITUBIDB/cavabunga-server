package tr.edu.itu.cavabunga.server.factory;

import tr.edu.itu.cavabunga.server.auth.AuthenticatedClient;

public interface AuthenticatedClientFactory {
    AuthenticatedClient createAuthenticatedClient();
}
