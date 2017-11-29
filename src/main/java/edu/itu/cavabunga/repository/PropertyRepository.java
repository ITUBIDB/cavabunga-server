package edu.itu.cavabunga.repository;

import edu.itu.cavabunga.entity.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<Property, Long> {
}
