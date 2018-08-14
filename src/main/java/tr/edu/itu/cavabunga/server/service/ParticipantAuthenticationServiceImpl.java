package tr.edu.itu.cavabunga.server.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.server.auth.AuthenticatedUser;
import tr.edu.itu.cavabunga.server.entity.ParticipantAuthorization;
import tr.edu.itu.cavabunga.server.exception.CavabungaAuthenticationException;
import tr.edu.itu.cavabunga.server.exception.CavabungaAuthorizationException;
import tr.edu.itu.cavabunga.server.factory.AuthenticatedUserFactory;

import java.util.List;

@Service
@Data
public class ParticipantAuthenticationServiceImpl implements ParticipantAuthenticationService {
    private ParticipantAuthorizationService participantAuthorizationService;
    private ParticipantService participantService;
    private AuthenticatedUserFactory authenticatedUserFactory;
    private String userName;
    private String password;

    @Autowired
    public ParticipantAuthenticationServiceImpl(ParticipantAuthorizationService participantAuthorizationService,
                                                ParticipantService participantService,
                                                AuthenticatedUserFactory authenticatedUserFactory){
        this.participantAuthorizationService = participantAuthorizationService;
        this.participantService = participantService;
        this.authenticatedUserFactory = authenticatedUserFactory;
    }

    @Override
    public AuthenticatedUser authenticateUser(){
        AuthenticatedUser authenticatedUser = authenticatedUserFactory.createAuthenticatedUser();
        Participant participant;
        List<ParticipantAuthorization> participantAuthorizations;

        try {
            participant = participantService.getParticipantByUserName(userName).get();
            if(!participant.getPassword().equals(password)){
                throw new CavabungaAuthenticationException("Username or password wrong");
            }
        }catch (Exception e){
            throw new CavabungaAuthorizationException("Participant cannot be authenticate: " + userName);
        }

        try {
            participantAuthorizations = participantAuthorizationService.getParticipantAuthorizationByParticipant(participant);
        }catch (Exception e){
            throw new CavabungaAuthorizationException("Cannot authorize the participant with username:" + userName);
        }

        authenticatedUser.setParticipant(participant);
        for(ParticipantAuthorization authorization: participantAuthorizations){
            authenticatedUser.addPermission(authorization.getPermission());
        }
        return authenticatedUser;
    }
}
