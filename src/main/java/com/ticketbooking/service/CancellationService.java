package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Cancellation;
import com.ticketbooking.repository.CancellationRepository;


@Transactional
@Service
public class CancellationService 
{
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private CancellationRepository cancellationRepository;
	
	public Boolean create(Cancellation c) 
	{
		Cancellation saved = cancellationRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Cancellation c) 
	{
		/*Category existingCategory = cancellationRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = cancellationRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		Cancellation existingEntity = cancellationRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		cancellationRepository.delete(existingEntity);
		
//		Category deletedCategory = cancellationRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Cancellation> findAll() 
	{
		List<Cancellation> list = cancellationRepository.findAll();
		return list;
	}

	public Cancellation findOne(Integer id) 
	{
		Cancellation entity = cancellationRepository.getOne(id);
		return entity;
	}

}
