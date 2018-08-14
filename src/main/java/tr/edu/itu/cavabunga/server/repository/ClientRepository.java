package tr.edu.itu.cavabunga.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.itu.cavabunga.server.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findById(Long id);

    Client findByAccessToken(String access_token);
}
