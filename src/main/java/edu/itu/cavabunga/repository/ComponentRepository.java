package edu.itu.cavabunga.repository;

import edu.itu.cavabunga.lib.entity.Component;
import edu.itu.cavabunga.lib.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    Optional<Component> findById(Long Id);
    List<Component> findByOwner(Participant owner);
}
