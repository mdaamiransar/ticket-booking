package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.LayoutType;
import com.ticketbooking.repository.LayoutTypeRepository;


@Transactional
@Service
public class LayoutTypeService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private LayoutTypeRepository layoutTypeRepository;
	
	public Boolean create(LayoutType entity) 
	{
		LayoutType saved = layoutTypeRepository.save(entity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(LayoutType entity) 
	{
		LayoutType existingEntity = layoutTypeRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		LayoutType saved = layoutTypeRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		LayoutType existingEntity = layoutTypeRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		layoutTypeRepository.delete(existingEntity);
		
//		Category deletedCategory = layoutTypeRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<LayoutType> findAll() 
	{
		List<LayoutType> list = layoutTypeRepository.findAll();
		return list;
	}

	public LayoutType findOne(Integer id) 
	{
		LayoutType entity = layoutTypeRepository.getOne(id);
		return entity;
	}

}
