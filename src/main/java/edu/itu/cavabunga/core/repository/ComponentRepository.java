package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Component
public interface ComponentRepository extends CrudRepository<Component, Long> {
    Component findById (Long id);

    List<Component> findByOwner(Participant owner);

    @Query("select a from Component a where owner=?1 and type = ?2")
    List<Component> findByOwnerAndType(Participant owner, String type);
}
