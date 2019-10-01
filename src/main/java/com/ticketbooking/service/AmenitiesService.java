package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Amenities;
import com.ticketbooking.repository.AmenitiesRepository;


@Transactional
@Service
public class AmenitiesService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private AmenitiesRepository amenitiesRepository;
	
	public Boolean create(Amenities entity) 
	{
		Amenities saved = amenitiesRepository.save(entity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Amenities entity) 
	{
		Amenities existingEntity = amenitiesRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		Amenities saved = amenitiesRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		Amenities existingEntity = amenitiesRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		amenitiesRepository.delete(existingEntity);
		
//		Category deletedCategory = amenitiesRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Amenities> findAll() 
	{
		List<Amenities> list = amenitiesRepository.findAll();
		return list;
	}

	public Amenities findOne(Integer id) 
	{
		Amenities entity = amenitiesRepository.getOne(id);
		return entity;
	}

}
