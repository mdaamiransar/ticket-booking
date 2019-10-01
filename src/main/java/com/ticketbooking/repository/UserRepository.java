package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticketbooking.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	//@Query("SELECT p FROM User p WHERE p.username = ?1 AND p.password = ?2")
	@Query("SELECT t FROM User t where t.username = :username AND t.password = :password")
	//@Query(value = "SELECT * FROM user t where t.username = :username AND t.password = :password", nativeQuery=true)
	User findByUsernameAndPassword(@Param("username") String username, @Param("password")String password);
	
	@Query("SELECT t FROM User t where t.username = :username")
	User findByUsername(@Param("username") String username);
} 