package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.BookingDetails;
import com.ticketbooking.repository.BookingDetailsRepository;


@Transactional
@Service
public class BookingDetailsService 
{
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;
	
	public Boolean create(BookingDetails c) 
	{
		BookingDetails saved = bookingDetailsRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(BookingDetails c) 
	{
		/*Category existingCategory = bookingDetailsRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = bookingDetailsRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		BookingDetails existingEntity = bookingDetailsRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		bookingDetailsRepository.delete(existingEntity);
		
//		Category deletedCategory = bookingDetailsRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<BookingDetails> findAll() 
	{
		List<BookingDetails> list = bookingDetailsRepository.findAll();
		return list;
	}

	public BookingDetails findOne(Integer id) 
	{
		BookingDetails entity = bookingDetailsRepository.getOne(id);
		return entity;
	}

}
