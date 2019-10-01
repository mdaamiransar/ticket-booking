package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.PartnerProgram;
import com.ticketbooking.repository.PartnerProgramRepository;


@Transactional
@Service
public class PartnerProgramService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private PartnerProgramRepository partnerProgramRepository;
	
	public Boolean create(PartnerProgram c) 
	{
		PartnerProgram saved = partnerProgramRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(PartnerProgram c) 
	{
		/*Category existingCategory = partnerProgramRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = partnerProgramRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		PartnerProgram existingEntity = partnerProgramRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		partnerProgramRepository.delete(existingEntity);
		
//		Category deletedCategory = partnerProgramRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<PartnerProgram> findAll() 
	{
		List<PartnerProgram> list = partnerProgramRepository.findAll();
		return list;
	}

	public PartnerProgram findOne(Long id) 
	{
		PartnerProgram entity = partnerProgramRepository.getOne(id);
		return entity;
	}

}
