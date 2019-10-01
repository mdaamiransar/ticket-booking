package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
	
} 