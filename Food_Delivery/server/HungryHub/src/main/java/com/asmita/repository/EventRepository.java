package com.asmita.repository;

import com.asmita.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Events, Long>{

	public List<Events> findEventsByRestaurantId(Long id);
}