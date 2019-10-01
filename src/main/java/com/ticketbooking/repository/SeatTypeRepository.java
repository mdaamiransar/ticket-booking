package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.SeatType;

public interface SeatTypeRepository extends JpaRepository<SeatType, Integer> {
	
} 