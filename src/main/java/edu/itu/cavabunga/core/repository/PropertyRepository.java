package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PropertyRepository extends CrudRepository<Property, Long> {
}
