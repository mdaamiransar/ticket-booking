package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Amenities;

public interface AmenitiesRepository extends JpaRepository<Amenities, Integer> {
	
} 