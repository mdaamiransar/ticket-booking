package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.City;
import com.ticketbooking.repository.CityRepository;


@Transactional
@Service
public class CityService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private CityRepository cityRepository;
	
	public Boolean create(City entity) 
	{
		City saved = cityRepository.save(entity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(City entity) 
	{
		City existingEntity = cityRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		City saved = cityRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		City existingEntity = cityRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		cityRepository.delete(existingEntity);
		
//		Category deletedCategory = cityRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<City> findAll() 
	{
		List<City> list = cityRepository.findAll();
		return list;
	}

	public City findOne(Integer id) 
	{
		City entity = cityRepository.getOne(id);
		return entity;
	}

}
