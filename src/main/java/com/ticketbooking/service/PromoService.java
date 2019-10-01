package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Promo;
import com.ticketbooking.repository.PromoRepository;


@Transactional
@Service
public class PromoService 
{
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private PromoRepository promoRepository;
	
	public Boolean create(Promo c) 
	{
		Promo saved = promoRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Promo c) 
	{
		/*Category existingCategory = promoRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = promoRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		Promo existingEntity = promoRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		promoRepository.delete(existingEntity);
		
//		Category deletedCategory = promoRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Promo> findAll() 
	{
		List<Promo> list = promoRepository.findAll();
		return list;
	}

	public Promo findOne(Integer id) 
	{
		Promo entity = promoRepository.getOne(id);
		return entity;
	}

}
