package com.ticketbooking.service;

import java.util.List;

import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketbooking.domain.Cart;
import com.ticketbooking.domain.CartLine;
import com.ticketbooking.domain.UserModel;
import com.ticketbooking.repository.CartLineRepository;
import com.ticketbooking.repository.CartRepository;

@Transactional
@Service
public class CartService {
	protected static Logger logger = Logger.getLogger("service");

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartLineRepository cartLineRepository;

	@Autowired
	private HttpSession session;

	public Boolean create(Cart c) {
		Cart saved = cartRepository.save(c);
		if (saved == null)
			return false;

		return true;
	}

	public Boolean update(Cart entity) {
		/*Cart existingEntity = cartRepository.findOne(entity.getId());
		if (existingEntity == null)
			return false;

		existingEntity.setId(entity.getId());*/

		Cart saved = cartRepository.save(entity);
		if (saved == null)
			return false;

		return true;
	}

	public Boolean delete(Long id) {
		Cart existingEntity = cartRepository.getOne(id);
		if (existingEntity == null)
			return false;

		cartRepository.delete(existingEntity);

		return true;
	}

	public List<Cart> findAll() {
		List<Cart> list = cartRepository.findAll();
		return list;
	}

	public Cart findOne(Long id) {
		Cart entity = cartRepository.getOne(id);
		return entity;
	}

	// returns the cart of the user who has logged in
	public Cart getCart() 
	{
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

}
