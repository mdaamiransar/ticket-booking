package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Vendor;
import com.ticketbooking.repository.VendorRepository;


@Transactional
@Service
public class VendorService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private VendorRepository vendorRepository;
	
	public Boolean create(Vendor c) 
	{
		Vendor saved = vendorRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Vendor c) 
	{
		/*Category existingCategory = useRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = useRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		Vendor existingEntity = vendorRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		vendorRepository.delete(existingEntity);

		return true;
	}

	public List<Vendor> findAll() 
	{
		List<Vendor> list = vendorRepository.findAll();
		return list;
	}

	public Vendor getOne(Long id) 
	{
		Vendor entity = vendorRepository.getOne(id);
		return entity;
	}

}
