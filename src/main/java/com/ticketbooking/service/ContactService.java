package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Contact;
import com.ticketbooking.repository.ContactRepository;


@Transactional
@Service
public class ContactService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Boolean create(Contact c) 
	{
		Contact saved = contactRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Contact c) 
	{
		/*Category existingCategory = contactRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = contactRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		Contact existingEntity = contactRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		contactRepository.delete(existingEntity);
		
//		Category deletedCategory = contactRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Contact> findAll() 
	{
		List<Contact> list = contactRepository.findAll();
		return list;
	}

	public Contact findOne(Long id) 
	{
		Contact entity = contactRepository.getOne(id);
		return entity;
	}

}
