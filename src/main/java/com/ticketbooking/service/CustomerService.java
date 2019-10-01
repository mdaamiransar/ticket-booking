package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Customer;
import com.ticketbooking.repository.CustomerRepository;


@Transactional
@Service
public class CustomerService 
{
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Boolean create(Customer c) 
	{
		Customer saved = customerRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Customer c) 
	{
		/*Category existingCategory = customerRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = customerRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		Customer existingEntity = customerRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		customerRepository.delete(existingEntity);
		
//		Category deletedCategory = customerRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Customer> findAll() 
	{
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	public Customer findOne(Integer id) 
	{
		Customer entity = customerRepository.getOne(id);
		return entity;
	}

}
