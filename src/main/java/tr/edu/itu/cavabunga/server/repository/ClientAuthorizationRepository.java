package tr.edu.itu.cavabunga.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.itu.cavabunga.server.entity.Client;
import tr.edu.itu.cavabunga.server.entity.ClientAuthorization;

import java.util.List;

@Repository
public interface ClientAuthorizationRepository extends JpaRepository<ClientAuthorization, Long> {
    ClientAuthorization findById(Long id);

    List<ClientAuthorization> findByClient(Client client);

}
