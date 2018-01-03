package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PropertyRepository extends CrudRepository<Property, Long> {
    List<Property> findByComponentToPropertyMap(edu.itu.cavabunga.core.entity.Component component);
}
