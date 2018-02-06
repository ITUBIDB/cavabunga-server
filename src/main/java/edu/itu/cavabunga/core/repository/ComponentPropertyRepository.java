package edu.itu.cavabunga.core.repository;

import edu.itu.cavabunga.core.entity.Component;
import edu.itu.cavabunga.core.entity.ComponentProperty;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Component
public interface ComponentPropertyRepository extends JpaRepository<ComponentProperty, Long> {
    ComponentProperty findByComponent(Component component);
}
