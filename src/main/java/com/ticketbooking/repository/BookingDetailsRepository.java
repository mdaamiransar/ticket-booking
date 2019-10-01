package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	
} 