package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.About;

public interface AboutRepository extends JpaRepository<About, Long> {
	
} 