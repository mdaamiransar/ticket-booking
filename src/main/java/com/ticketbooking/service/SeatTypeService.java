package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.SeatType;
import com.ticketbooking.repository.SeatTypeRepository;


@Transactional
@Service
public class SeatTypeService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private SeatTypeRepository seatTypeRepository;
	
	public Boolean create(SeatType entity) 
	{
		SeatType saved = seatTypeRepository.save(entity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(SeatType entity) 
	{
		SeatType existingEntity = seatTypeRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		SeatType saved = seatTypeRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		SeatType existingEntity = seatTypeRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		seatTypeRepository.delete(existingEntity);
		
//		Category deletedCategory = seatTypeRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<SeatType> findAll() 
	{
		List<SeatType> list = seatTypeRepository.findAll();
		return list;
	}

	public SeatType findOne(Integer id) 
	{
		SeatType entity = seatTypeRepository.getOne(id);
		return entity;
	}

}
