package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.SettingDetails;
import com.ticketbooking.repository.SettingDetailsRepository;


@Transactional
@Service
public class SettingDetailsService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private SettingDetailsRepository settingDetailsRepository;
	
	public Boolean create(SettingDetails entity) 
	{
		SettingDetails saved = settingDetailsRepository.save(entity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(SettingDetails entity) 
	{
		SettingDetails existingEntity = settingDetailsRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		SettingDetails saved = settingDetailsRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		SettingDetails existingEntity = settingDetailsRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		settingDetailsRepository.delete(existingEntity);
		
//		Category deletedCategory = settingDetailsRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<SettingDetails> findAll() 
	{
		List<SettingDetails> list = settingDetailsRepository.findAll();
		return list;
	}

	public SettingDetails findOne(Integer id) 
	{
		SettingDetails entity = settingDetailsRepository.getOne(id);
		return entity;
	}

}
