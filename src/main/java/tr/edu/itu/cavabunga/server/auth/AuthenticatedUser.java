package tr.edu.itu.cavabunga.server.auth;

import lombok.Data;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.server.entity.ParticipantPermissionEnum;

import java.util.List;

@Data
public class AuthenticatedUser {
    private Participant participant;

    private List<ParticipantPermissionEnum> permissions;

    public void addPermission(ParticipantPermissionEnum participantPermissionEnum){
        this.permissions.add(participantPermissionEnum);
    }

    public void removePermession(ParticipantPermissionEnum participantPermissionEnum){
        this.permissions.remove(participantPermissionEnum);
    }

}
