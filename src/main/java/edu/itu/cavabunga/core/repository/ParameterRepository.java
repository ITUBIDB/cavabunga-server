package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Parameter;
import edu.itu.cavabunga.core.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    Optional<Parameter> findById(Long Id);

    Optional<List<Parameter>> findByProperty(Property property);

    @Query("select a from Parameter a where type = ?1")
    Optional<List<Parameter>> findByType(String type);
}
