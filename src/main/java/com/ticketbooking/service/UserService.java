package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.User;
import com.ticketbooking.repository.UserRepository;


@Transactional
@Service
public class UserService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private UserRepository userRepository;
	
	public Boolean create(User c) 
	{
		User saved = userRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(User c) 
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
		User existingEntity = userRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		userRepository.delete(existingEntity);
		
//		Category deletedCategory = useRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<User> findAll() 
	{
		List<User> list = userRepository.findAll();
		return list;
	}

	public User getOne(Long id) 
	{
		User entity = userRepository.getOne(id);
		return entity;
	}
	
	public User findByUsernameAndPassword(String username, String password)
	{
		User entity = userRepository.findByUsernameAndPassword(username, password);
		
		return entity;
	}
	
	public User findByUsername(String username)
	{
		User entity = userRepository.findByUsername(username);
		
		return entity;
	}

}
