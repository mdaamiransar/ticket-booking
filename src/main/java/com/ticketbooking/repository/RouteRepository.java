package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketbooking.domain.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {
	
	@Query("SELECT t FROM Route t where t.boardPoint = :boardPoint AND t.dropPoint = :dropPoint")
	List<Route> findBusesByRoute(@Param("boardPoint") String boardPoint, @Param("dropPoint") String dropPoint);
	
	@Query("SELECT DISTINCT t.boardPoint FROM Route t WHERE t.boardPoint like %:query%")
	List<String> findBoardPointFromRoute(@Param("query") String query);
	
	@Query("Select DISTINCT t.dropPoint FROM Route t WHERE t.dropPoint like %:query%")
	List<String> findDropPointFromRoute(@Param("query") String query);
	
} 