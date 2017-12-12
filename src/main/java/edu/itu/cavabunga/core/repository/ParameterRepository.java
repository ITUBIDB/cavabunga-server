package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Parameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ParameterRepository extends CrudRepository<Parameter, Long> {
}
