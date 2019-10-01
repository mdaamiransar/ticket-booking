package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
} 