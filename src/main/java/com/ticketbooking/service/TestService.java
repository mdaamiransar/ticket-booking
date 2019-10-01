package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Test;
import com.ticketbooking.repository.TestRepository;


@Transactional
@Service
public class TestService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private TestRepository testRepository;
	
	public Boolean create(Test c) 
	{
		Test saved = testRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Test c) 
	{
		/*Category existingCategory = testRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = testRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		Test existingEntity = testRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		testRepository.delete(existingEntity);
		
//		Category deletedCategory = testRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Test> findAll() 
	{
		List<Test> list = testRepository.findAll();
		return list;
	}

	public Test findOne(Long id) 
	{
		Test entity = testRepository.getOne(id);
		return entity;
	}

}
