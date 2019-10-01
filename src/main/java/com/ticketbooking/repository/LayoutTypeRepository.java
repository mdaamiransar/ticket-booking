package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.LayoutType;

public interface LayoutTypeRepository extends JpaRepository<LayoutType, Integer> {
	
} 