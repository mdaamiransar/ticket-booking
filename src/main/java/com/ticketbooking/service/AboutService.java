package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.About;
import com.ticketbooking.repository.AboutRepository;


@Transactional
@Service
public class AboutService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private AboutRepository aboutRepository;
	
	public Boolean create(About c) 
	{
		About saved = aboutRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(About c) 
	{
		/*Category existingCategory = aboutRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = aboutRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		About existingEntity = aboutRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		aboutRepository.delete(existingEntity);
		
//		Category deletedCategory = aboutRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<About> findAll() 
	{
		List<About> list = aboutRepository.findAll();
		return list;
	}

	public About findOne(Long id) 
	{
		About entity = aboutRepository.getOne(id);
		return entity;
	}

}
