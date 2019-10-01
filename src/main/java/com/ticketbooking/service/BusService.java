package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Bus;
import com.ticketbooking.repository.BusRepository;


@Transactional
@Service
public class BusService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private BusRepository busRepository;
	
	public Boolean create(Bus entity) 
	{
		Bus saved = busRepository.save(entity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Bus entity) 
	{
		Bus existingEntity = busRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		Bus saved = busRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		Bus existingEntity = busRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		busRepository.delete(existingEntity);
		
//		Category deletedCategory = busRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Bus> findAll() 
	{
		List<Bus> list = busRepository.findAll();
		return list;
	}

	public Bus findOne(Integer id) 
	{
		Bus entity = busRepository.getOne(id);
		return entity;
	}

	
	public List<Bus> findActiveBus(Boolean status) {

		List<Bus> list = busRepository.findActiveBus(status);
		return list;
	}

}
