package edu.itu.cavabunga.caldav.repository;

import edu.itu.cavabunga.caldav.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PropertyRepository extends CrudRepository<Property, Long> {
}
