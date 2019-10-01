package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.BusType;
import com.ticketbooking.repository.BusTypeRepository;


@Transactional
@Service
public class BusTypeService {
//protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private BusTypeRepository busTypeRepository;
	
	public Boolean create(BusType entity) 
	{
		BusType saved = busTypeRepository.save(entity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(BusType entity) 
	{
		BusType existingEntity = busTypeRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		BusType saved = busTypeRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		BusType existingEntity = busTypeRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		busTypeRepository.delete(existingEntity);
		
//		Category deletedCategory = busTypeRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<BusType> findAll() 
	{
		List<BusType> list = busTypeRepository.findAll();
		return list;
	}

	public BusType findOne(Integer id) 
	{
		BusType entity = busTypeRepository.getOne(id);
		return entity;
	}

}
