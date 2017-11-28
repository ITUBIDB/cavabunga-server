package edu.itu.cavabunga.repositories;

import edu.itu.cavabunga.entities.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<Calendar, Integer> {
}
