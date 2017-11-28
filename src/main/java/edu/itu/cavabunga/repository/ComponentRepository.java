package edu.itu.cavabunga.repository;

import edu.itu.cavabunga.entity.Component;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepository extends CrudRepository<Component, Integer> {
}
