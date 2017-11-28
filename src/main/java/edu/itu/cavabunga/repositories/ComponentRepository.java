package edu.itu.cavabunga.repositories;

import edu.itu.cavabunga.entities.Component;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepository extends CrudRepository<Component, Integer> {
}
