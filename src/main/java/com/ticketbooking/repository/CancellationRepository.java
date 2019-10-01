package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Cancellation;

public interface CancellationRepository extends JpaRepository<Cancellation, Integer> {
	
} 