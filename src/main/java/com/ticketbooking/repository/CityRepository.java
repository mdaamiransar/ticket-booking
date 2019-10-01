package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketbooking.domain.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	@Query("SELECT DISTINCT t.name FROM City t WHERE t.name like %:query%")
	List<String> findNameFromCity(@Param("query") String query);
	

} 