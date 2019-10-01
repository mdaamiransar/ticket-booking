package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Category;
import com.ticketbooking.repository.CategoryRepository;


@Transactional
@Service
public class CategoryService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Boolean create(Category c) 
	{
		Category saved = categoryRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Category entity) 
	{
		Category existingEntity = categoryRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		Category saved = categoryRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		Category existingEntity = categoryRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		categoryRepository.delete(existingEntity);

		return true;
	}

	public List<Category> findAll() 
	{
		List<Category> list = categoryRepository.findAll();
		return list;
	}

	public Category getOne(Long id) 
	{
		Category entity = categoryRepository.getOne(id);
		return entity;
	}

}
