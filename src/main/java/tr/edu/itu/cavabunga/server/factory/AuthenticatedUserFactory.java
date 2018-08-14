package tr.edu.itu.cavabunga.server.factory;

import tr.edu.itu.cavabunga.server.auth.AuthenticatedUser;

public interface AuthenticatedUserFactory {
    AuthenticatedUser createAuthenticatedUser();
}
