package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.Participant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Component
public interface ComponentRepository extends CrudRepository<Component, Long> {
    List<Component> findByOwner(Participant owner);

    List<Component> findByParent(Component component);

    @Query("select c from Component c where parent=?1 and type=?2")
    List<Component> findByParentAndType(Component component, String type);

    @Query("select b from Component b where type = ?1")
    List<Component> findByType(String type);

    @Query("select a from Component a where owner=?1 and type = ?2")
    List<Component> findByOwnerAndType(Participant owner, String type);
}
