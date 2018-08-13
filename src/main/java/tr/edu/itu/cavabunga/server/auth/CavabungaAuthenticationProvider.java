package tr.edu.itu.cavabunga.server.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.DispatcherServlet;
import tr.edu.itu.cavabunga.server.configuration.CavabungaAuthenticationConfiguration;
import tr.edu.itu.cavabunga.server.service.ClientAuthenticationService;
import tr.edu.itu.cavabunga.server.service.ParticipantAuthenticationService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Collections;

@Component
public class CavabungaAuthenticationProvider implements AuthenticationProvider {
    private ParticipantAuthenticationService participantAuthenticationService;
    private CavabungaAuthenticationConfiguration cavabungaAuthenticationConfiguration;

    @Autowired
    public CavabungaAuthenticationProvider(ParticipantAuthenticationService participantAuthenticationService,
                                           CavabungaAuthenticationConfiguration cavabungaAuthenticationConfiguration) {

        this.participantAuthenticationService = participantAuthenticationService;
        this.cavabungaAuthenticationConfiguration = cavabungaAuthenticationConfiguration;
    }


    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials().toString();

        this.authenticateParticipant(username, password);
        return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
    }

    public void authenticateParticipant(String username, String password) {
        participantAuthenticationService.setUserName(username);
        participantAuthenticationService.setPassword(password);
        //participantAuthenticationService.authenticateUser();
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

}