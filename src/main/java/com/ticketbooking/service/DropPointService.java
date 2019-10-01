package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.DropPoint;
import com.ticketbooking.repository.DropPointRepository;


@Transactional
@Service
public class DropPointService 
{
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private DropPointRepository dropPointRepository;
	
	public Boolean create(DropPoint c) 
	{
		DropPoint saved = dropPointRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(DropPoint c) 
	{
		/*Category existingCategory = dropPointRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = dropPointRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		DropPoint existingEntity = dropPointRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		dropPointRepository.delete(existingEntity);
		
//		Category deletedCategory = dropPointRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<DropPoint> findAll() 
	{
		List<DropPoint> list = dropPointRepository.findAll();
		return list;
	}

	public DropPoint findOne(Integer id) 
	{
		DropPoint entity = dropPointRepository.getOne(id);
		return entity;
	}

}
