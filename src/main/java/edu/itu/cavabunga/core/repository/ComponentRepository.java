package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Component;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Component
public interface ComponentRepository extends CrudRepository<Component, Integer> {


}
