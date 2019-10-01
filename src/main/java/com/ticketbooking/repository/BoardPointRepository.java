package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ticketbooking.domain.BoardPoint;

public interface BoardPointRepository extends JpaRepository<BoardPoint, Integer> {
	
	//select t.boardingPoint from boardPoint t where t.route='1'
	@Query("from BoardPoint where bus= ?1")
	List<BoardPoint> loadBoardings(Integer bus);
	
} 