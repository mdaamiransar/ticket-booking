package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketbooking.domain.SeatLayout;

public interface SeatLayoutRepository extends JpaRepository<SeatLayout, Integer> {
	
	@Query("SELECT t FROM SeatLayout t where t.seatType = :seatType")
	SeatLayout findSeatType(@Param("seatType") String seatType);
	
	@Query("SELECT t FROM SeatLayout t where t.bus = :bus")
	List<SeatLayout> findSeatLayoutByBus(@Param("bus") Integer bus);
	
	@Query("SELECT t FROM SeatLayout t where t.length = :length and t.bus = :bus")	//length indicates seat type
	List<SeatLayout> findBusSeatLayoutByLength(@Param("length") Integer length, @Param("bus") Integer bus);  // length - seater/vertical sleeper/horizontal sleeper
	
	@Query("SELECT t FROM SeatLayout t where t.row = :row")	//length indicates seat type
	List<SeatLayout> findRowFromSeatLayout(@Param("row") Integer row);  // length - seater/vertical sleeper/horizontal sleeper

	@Query("SELECT t FROM SeatLayout t where t.name = :name")	//length indicates seat type
	SeatLayout findBySeatName(@Param("name") String seatNo);
	
} 