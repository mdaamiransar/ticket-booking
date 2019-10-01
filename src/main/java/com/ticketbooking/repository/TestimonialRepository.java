package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Testimonial;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
	
} 