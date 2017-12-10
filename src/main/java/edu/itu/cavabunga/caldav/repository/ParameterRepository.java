package edu.itu.cavabunga.caldav.repository;

import edu.itu.cavabunga.caldav.entity.Parameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ParameterRepository extends CrudRepository<Parameter, Long> {
}
