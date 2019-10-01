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
import com.ticketbooking.domain.Product;
import com.ticketbooking.domain.UserModel;
import com.ticketbooking.repository.CartLineRepository;
import com.ticketbooking.repository.CartRepository;
import com.ticketbooking.repository.ProductRepository;


@Transactional
@Service
public class CartLineService {
protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private CartLineRepository cartLineRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private HttpSession session;
	
	public Boolean create(CartLine c) 
	{
		CartLine saved = cartLineRepository.save(c);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean update(CartLine entity) 
	{
		CartLine existingEntity = cartLineRepository.getOne(entity.getId());
		if (existingEntity == null) 
			return false;
		
		existingEntity.setId(entity.getId());
		
		CartLine saved = cartLineRepository.save(existingEntity);
		if (saved == null) 
			return false;
		
		return true;
	}

	public Boolean delete(Long id) 
	{
		CartLine existingEntity = cartLineRepository.getOne(id);
		if (existingEntity == null) 
			return false;
		
		cartLineRepository.delete(existingEntity);

		return true;
	}

	public List<CartLine> findAll() 
	{
		List<CartLine> list = cartLineRepository.findAll();
		return list;
	}

	//find by cartLineId
	public CartLine findOne(Long id) 
	{
		CartLine entity = cartLineRepository.getOne(id);
		return entity;
	}
	
	// returns the cart of the user who has logged in
	public Cart getCart() 
	{
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
//	SELECT * FROM cartline WHERE cartline.`cartId`=1
	public List<CartLine> getCartLines() {
		return cartLineRepository.findByCartId(cartService.getCart().getId());
	}

//	public String addCartLine(Long productId) {
//
//		String response = null;
//		
//		Cart cart = this.cartService.getCart();
//		
//		CartLine cartLine = cartLineRepository.getByCartAndProduct(cart.getId(), productId);
//		
//		if(cartLine == null)
//		{
//			//add cartline
//			cartLine = new CartLine();
//			
//			//fetch product
//			Product product = productRepository.findOne(productId);
//			
//			cartLine.setCartId(cart.getId());
//			cartLine.setProduct(product);
//			cartLine.setBuyingPrice(product.getUnitPrice());
//			cartLine.setProductCount(1);
//			cartLine.setTotal(product.getUnitPrice());
//			cartLine.setAvailable(true);
//			
//			cartLineRepository.save(cartLine);
//			
//			//updateCart
//			cart.setCartLines(cart.getCartLines() + 1);
//			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
//			
//			cartService.create(cart);
//			
//			response = "result=added";
//		}
//		else
//		{
//			//check if the cartLine has reached the maximum count
//			if(cartLine.getProductCount() < 3)
//			{
//				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount()+1);
//			}
//			else
//			{
//				response = "result=maximum";
//			}
//		}
//		return response;
//	}

	public String manageCartLine(Long cartLineId, int count) {
		
		CartLine cartLine = cartLineRepository.getOne(cartLineId);		

		double oldTotal = cartLine.getTotal();

		
		Product product = cartLine.getProduct();
		
		// check if that much quantity is available or not
		if(product.getQuantity() < count) {
			return "result=unavailable";		
		}	
		
		// update the cart line
		cartLine.setProductCount(count);
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setTotal(product.getUnitPrice() * count);
//		cartLineRepository.update(cartLine);
		cartLineRepository.save(cartLine);
	
		// update the cart
		Cart cart = this.cartService.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
//		cartLineDAO.updateCart(cart);
		
		cartService.create(cart);
		
		return "result=updated";
	}

	public String deleteCartLine(Long cartLineId) {

		//fetch the cartLine
		CartLine cartLine = cartLineRepository.getOne(cartLineId);
		
		if(cartLine == null)
		{
			return "result=error";
		}
		else
		{
			// deduct the cart
			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartService.update(cart);
			
			logger.info("********cart.getGrandTotal() - cartLine.getTotal()**********" + (cart.getGrandTotal() - cartLine.getTotal()));
			logger.info("********cart.getCartLines() - 1**********" + (cart.getCartLines() - 1));
			logger.info("********cartService.update(cart)**********" + (cartService.update(cart)));
	
			// remove the cartLine
			cartLineRepository.delete(cartLine);
	
			return "result=deleted";
		}
	}
	
	public String validateCartLine() {
		Cart cart = this.getCart();
		List<CartLine> cartLines = cartLineRepository.findByCartId(cart.getId());
		double grandTotal = 0.0;
		Long lineCount = 0l;
		String response = "result=success";
		boolean changed = false;
		Product product = null;
		for(CartLine cartLine : cartLines) {					
			product = cartLine.getProduct();
			changed = false;
			// check if the product is active or not
			// if it is not active make the availability of cartLine as false
			if((!product.getStatus() && product.getQuantity() == 0) && cartLine.getAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}			
			// check if the cartLine is not available
			// check whether the product is active and has at least one quantity available
			if((product.getStatus() && product.getQuantity() > 0) && !(cartLine.getAvailable())) {
					cartLine.setAvailable(true);
					changed = true;
			}
			
			// check if the buying price of product has been changed
			if(cartLine.getBuyingPrice() != product.getUnitPrice()) {
				// set the buying price to the new price
				cartLine.setBuyingPrice(product.getUnitPrice());
				// calculate and set the new total
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;				
			}
			
			// check if that much quantity of product is available or not
			if(cartLine.getProductCount() > product.getQuantity()) {
				cartLine.setProductCount(product.getQuantity());										
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;
				
			}
			
			// changes has happened
			if(changed) {				
				//update the cartLine
				cartLineRepository.save(cartLine);
				// set the result as modified
				response = "result=modified";
			}
			
			grandTotal += cartLine.getTotal();
			lineCount++;
		}
		
		cart.setCartLines(lineCount++);
		cart.setGrandTotal(grandTotal);
		//cartLineService.updateCart(cart);
		cartRepository.save(cart);

		return response;
	}	

}
