package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticketbooking.domain.Product;

//@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
//	@Query("SELECT t FROM Product t where t.status = true")
	//@Query(value = "SELECT * FROM user t where t.username = :username AND t.password = :password", nativeQuery=true)
//	@Query(value="select *  from Product where status=true order by id desc limit 0, 5 ", nativeQuery=true)
//	List<Product> findActiveProducts2();
	
	//Working -- Fetching only Active Products
	@Query("SELECT t FROM Product t where t.status = :status")
	List<Product> findActiveProducts(@Param("status") Boolean status);
	
//	@Query("SELECT * FROM roduct WHERE status = ?1 LIMIT 1", nativeQuery = true)
//	List<Product> findLatestActiveProducts(Boolean status, Integer count);
	
	@Query(value="select * from Product where status=? order by id asc limit 4 ", nativeQuery=true)
	List<Product> findNext4ProductById(@Param("status") Boolean status);
	
	@Query(value="select t from Product t where t.status = :status order by id")
	List<Product> findLast4ProductById(@Param("status") Boolean status);
} 