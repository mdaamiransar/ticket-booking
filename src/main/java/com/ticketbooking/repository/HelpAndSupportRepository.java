package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.HelpAndSupport;

public interface HelpAndSupportRepository extends JpaRepository<HelpAndSupport, Long> {
	
} 