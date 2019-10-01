package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Contact;;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
} 