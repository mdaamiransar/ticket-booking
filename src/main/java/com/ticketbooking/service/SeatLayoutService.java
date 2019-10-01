package com.ticketbooking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.SeatLayout;
import com.ticketbooking.repository.SeatLayoutRepository;
import com.ticketbooking.util.SeatLayoutHelper;


@Transactional
@Service
public class SeatLayoutService 
{
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private SeatLayoutRepository seatLayoutRepository;
	
	public Boolean create(SeatLayout c) 
	{
		SeatLayout saved = seatLayoutRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(SeatLayout c) 
	{
		SeatLayout existingEntity = seatLayoutRepository.getOne(c.getId());
		if (existingEntity == null) 
			return false;
		
		//existingEntity.setName(c.getName());
		
		SeatLayout saved = seatLayoutRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		SeatLayout existingEntity = seatLayoutRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		seatLayoutRepository.delete(existingEntity);
		
		return true;
	}

	public List<SeatLayout> findAll() 
	{
		List<SeatLayout> list = seatLayoutRepository.findAll();
		return list;
	}

	public SeatLayout findOne(Integer id) 
	{
		SeatLayout entity = seatLayoutRepository.getOne(id);
		return entity;
	}
	
	public Map<String, SeatLayout[][]> loadSeatLayout(Integer busId)
	{
		try
		{
			List<SeatLayout> busSeatLayout =  seatLayoutRepository.findSeatLayoutByBus(busId);
			List<SeatLayout> lowerBerth = busSeatLayout.stream().filter(seat -> seat.getZindex() == 0).collect(Collectors.toList());

			Map<String, SeatLayout[][]> berthWiseSeats = new HashMap<String, SeatLayout[][]>(); 
						
			//Lower berth preparation
			int lRows = lowerBerth.stream().filter(SeatLayoutHelper.distinctByKey(SeatLayout::getRow)).collect(Collectors.toList()).size();
			int lCols = lowerBerth.stream().filter(SeatLayoutHelper.distinctByKey(SeatLayout::getCol)).collect(Collectors.toList()).size();
			SeatLayout[][] lSeats = new SeatLayout[lRows][lCols];
			for(SeatLayout layout: lowerBerth){
				lSeats[layout.getRow()][layout.getCol()] = layout;
			}
			berthWiseSeats.put("L-BERTH", lSeats);
			
			//Upper berth preparation
			boolean hasUpperBerth = busSeatLayout.stream().anyMatch(seat-> seat.getZindex()==1);
			if(hasUpperBerth){
				List<SeatLayout> upperBerth = busSeatLayout.stream().filter(seat -> seat.getZindex() == 1).collect(Collectors.toList());
				int uRows = upperBerth.stream().filter(SeatLayoutHelper.distinctByKey(SeatLayout::getRow)).collect(Collectors.toList()).size();
				logger.warn("harry urows: " +uRows);
				int uCols = upperBerth.stream().filter(SeatLayoutHelper.distinctByKey(SeatLayout::getCol)).collect(Collectors.toList()).size();
				logger.warn("harry ucols: " +uCols);
				SeatLayout[][] uSeats = new SeatLayout[uRows][uCols];
				for(SeatLayout layout: upperBerth){
					logger.warn(" layout ::: "+ " ::::"+layout.getSeatStatus());
					uSeats[layout.getRow()][layout.getCol()] = layout;
				}
				berthWiseSeats.put("U-BERTH", uSeats);
			}
			return berthWiseSeats;
		}catch(Exception e){
			logger.error("error occurred while loading seatLayout, the error is: "+e.getMessage(), e);
		}
		return null;
	
	}
	
}
