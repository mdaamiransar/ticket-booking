package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketbooking.domain.SettingDetails;

public interface SettingDetailsRepository extends JpaRepository<SettingDetails, Integer> {
	
} 