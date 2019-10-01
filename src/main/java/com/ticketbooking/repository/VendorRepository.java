package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
	
} 