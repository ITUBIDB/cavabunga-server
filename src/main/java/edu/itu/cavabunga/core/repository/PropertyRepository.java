package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PropertyRepository extends CrudRepository<Property, Long> {
    List<Property> findByComponent(edu.itu.cavabunga.core.entity.Component component);

    @Query("select a from Property a where type = ?1")
    List<Property> findByType(String type);

    @Query("select b from Property b where component=?1 and type =?2")
    List<Property> findByComponentAndType(edu.itu.cavabunga.core.entity.Component component, String type);
}
