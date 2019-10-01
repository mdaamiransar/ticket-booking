package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Route;
import com.ticketbooking.repository.RouteRepository;


@Transactional
@Service
public class RouteService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private RouteRepository routeRepository;
	
	public Boolean create(Route c) 
	{
		Route saved = routeRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Route c) 
	{
		/*Category existingCategory = routeRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = routeRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		Route existingEntity = routeRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		routeRepository.delete(existingEntity);
		
//		Category deletedCategory = routeRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Route> findAll() 
	{
		List<Route> list = routeRepository.findAll();
		return list;
	}

	public Route findOne(Integer id) 
	{
		Route entity = routeRepository.getOne(id);
		return entity;
	}

}
