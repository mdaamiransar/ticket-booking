package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.HelpAndSupport;
import com.ticketbooking.repository.HelpAndSupportRepository;


@Transactional
@Service
public class HelpAndSupportService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private HelpAndSupportRepository helpAndSupportRepository;
	
	public Boolean create(HelpAndSupport c) 
	{
		HelpAndSupport saved = helpAndSupportRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(HelpAndSupport c) 
	{
		/*Category existingCategory = helpAndSupportRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = helpAndSupportRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		HelpAndSupport existingEntity = helpAndSupportRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		helpAndSupportRepository.delete(existingEntity);
		
//		Category deletedCategory = helpAndSupportRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<HelpAndSupport> findAll() 
	{
		List<HelpAndSupport> list = helpAndSupportRepository.findAll();
		return list;
	}

	public HelpAndSupport findOne(Long id) 
	{
		HelpAndSupport entity = helpAndSupportRepository.getOne(id);
		return entity;
	}

}
