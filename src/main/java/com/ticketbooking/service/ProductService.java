package com.ticketbooking.service;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Product;
import com.ticketbooking.repository.ProductRepository;


@Transactional
@Service
public class ProductService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private ProductRepository productRepository;
	
	public Boolean create(Product entity) 
	{
		Product saved = productRepository.save(entity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(Product entity) 
	{
		Product existingEntity = productRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		Product saved = productRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		Product existingEntity = productRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		productRepository.delete(existingEntity);
		
//		Category deletedCategory = productRepository.findOne(id);
//		if (deletedCategory != null) 
//			return false;

		return true;
	}

	public List<Product> findAll() 
	{
		List<Product> list = productRepository.findAll();
		return list;
	}

	public Product findOne(Long id) 
	{
		Product entity = productRepository.getOne(id);
		return entity;
	}

	
	public List<Product> findActiveProducts(Boolean status) {

		List<Product> list = productRepository.findActiveProducts(status);
		return list;
	}

}
