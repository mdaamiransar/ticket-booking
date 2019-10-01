package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticketbooking.domain.DropPoint;

public interface DropPointRepository extends JpaRepository<DropPoint, Integer> {
	

	@Query("from DropPoint where bus= ?1")
	List<DropPoint> loadDropings(Integer bus);
} 