package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Promo;

public interface PromoRepository extends JpaRepository<Promo, Integer> {
	
} 