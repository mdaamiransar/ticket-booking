package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ticketbooking.domain.CartLine;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long> {

	@Query("SELECT t FROM CartLine t WHERE t.cartId = :cartId")
	List<CartLine> findByCartId(@Param(value = "cartId") Long cartId);
	
	@Query("SELECT t FROM CartLine t WHERE t.cartId = :cartId AND t.available = true")
	List<CartLine> listAvailable(@Param(value = "cartId") Long cartId);
	
	@Query("SELECT t FROM CartLine t WHERE t.cartId = :cartId AND t.product.id = :productId")
	CartLine getByCartAndProduct(@Param(value = "cartId") Long cartId, @Param(value = "productId") Long productId);
	
} 