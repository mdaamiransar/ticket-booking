package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	

} 