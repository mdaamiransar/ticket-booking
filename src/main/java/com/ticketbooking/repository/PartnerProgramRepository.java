package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.PartnerProgram;


public interface PartnerProgramRepository extends JpaRepository<PartnerProgram, Long> {
	
} 