package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ticketbooking.domain.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
	
	@Query("SELECT t FROM Address t where t.userId = :userId AND t.billing = :billing")
	Address findBillingAddress(@Param("userId") String userId, @Param("billing") Boolean billing);
	
	@Query("SELECT t FROM Address t where t.userId = :userId AND t.shipping = :shipping")
	List<Address> findShippingAddress(@Param("userId") String userId, @Param("shipping") Boolean shipping);
} 