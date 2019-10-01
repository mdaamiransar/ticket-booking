package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Testimonial;
import com.ticketbooking.repository.TestimonialRepository;


@Transactional
@Service
public class TestimonialService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private TestimonialRepository testimonialRepository;
	
	public Boolean create(Testimonial c) 
	{
		Testimonial saved = testimonialRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Testimonial c) 
	{
		/*Category existingCategory = testimonialRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = testimonialRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		Testimonial existingEntity = testimonialRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		testimonialRepository.delete(existingEntity);
		
//		Category deletedCategory = testimonialRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Testimonial> findAll() 
	{
		List<Testimonial> list = testimonialRepository.findAll();
		return list;
	}

	public Testimonial findOne(Long id) 
	{
		Testimonial entity = testimonialRepository.getOne(id);
		return entity;
	}

}
