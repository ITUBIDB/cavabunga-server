package tr.edu.itu.cavabunga.server.entity;

import lombok.Data;
import tr.edu.itu.cavabunga.lib.entity.Participant;

import javax.persistence.*;

@Entity
@Data
public class ParticipantAuthorization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ParticipantPermissionEnum permission;

    @ManyToOne
    private Participant participant;

}
