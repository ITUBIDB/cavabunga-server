package tr.edu.itu.cavabunga.server.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ClientAuthorization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClientPermissionEnum permission;

    @ManyToOne
    private Client client;

}
