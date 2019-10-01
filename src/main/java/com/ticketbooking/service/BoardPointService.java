package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.BoardPoint;
import com.ticketbooking.repository.BoardPointRepository;


@Transactional
@Service
public class BoardPointService 
{
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private BoardPointRepository boardPointRepository;
	
	public Boolean create(BoardPoint c) 
	{
		BoardPoint saved = boardPointRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(BoardPoint c) 
	{
		/*Category existingCategory = boardPointRepository.findOne(c.getId());
		if (existingCategory == null) 
			return false;
		
		existingCategory.setName(c.getName());
		
		Category saved = boardPointRepository.save(existingCategory);
		if (saved == null) 
			return false;*/
		
		return true;
	}

	public Boolean delete(Integer id) 
	{
		BoardPoint existingEntity = boardPointRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		boardPointRepository.delete(existingEntity);
		
//		Category deletedCategory = boardPointRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<BoardPoint> findAll() 
	{
		List<BoardPoint> list = boardPointRepository.findAll();
		return list;
	}

	public BoardPoint findOne(Integer id) 
	{
		BoardPoint entity = boardPointRepository.getOne(id);
		return entity;
	}

}
