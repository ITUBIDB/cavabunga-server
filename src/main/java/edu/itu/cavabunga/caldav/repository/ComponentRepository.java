package edu.itu.cavabunga.caldav.repository;

import edu.itu.cavabunga.caldav.entity.Component;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Component
public interface ComponentRepository extends CrudRepository<Component, Integer> {


}
