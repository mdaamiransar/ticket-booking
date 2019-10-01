package com.ticketbooking.controller;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ticketbooking.domain.Cart;
import com.ticketbooking.domain.CartLine;
import com.ticketbooking.domain.Category;
import com.ticketbooking.domain.Product;
import com.ticketbooking.domain.Vendor;
import com.ticketbooking.repository.CartLineRepository;
import com.ticketbooking.repository.ProductRepository;
import com.ticketbooking.service.CartLineService;
import com.ticketbooking.service.CartService;
import com.ticketbooking.service.CategoryService;
import com.ticketbooking.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartLineController 
{
   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartLineService cartLineService;
	
	@Autowired
	private CartLineRepository cartLineRepository;
	
//	@Autowired
//	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result)
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Shopping User Cart");
		mv.addObject("userClickShowCart", true);
		
		if (result != null) 
		{

			switch(result) 
			{
				case "added":
					mv.addObject("message", "Product has been successfully added inside cart!");					
//					cartLineService.validateCartLine();
					break;
				case "unavailable":
					mv.addObject("message", "Product quantity is not available!");					
					break;
				case "updated":
					mv.addObject("message", "Cart has been updated successfully!");					
//					cartLineService.validateCartLine();
					break;
				case "modified":
					mv.addObject("message", "One or more items inside cart has been modified!");
					break;
				case "maximum":
					mv.addObject("message", "Maximum limit for the item has been reached!");
					break;
				case "deleted":
					mv.addObject("message", "CartLine has been successfully removed!");
					break;
			}
		}
		else
		{
			String response = "result=success";//cartService.validateCartLine();
			if(response.equals("result=modified")) {
				mv.addObject("message", "One or more items inside cart has been modified!");
			}
		}
		
		mv.addObject("cartLines", cartLineService.getCartLines());
		
		return mv;
	}
	
//	@RequestMapping("/add/{productId}/productq")
//	public String addCartLine(@PathVariable Long productId) {
//		String response = cartLineService.addCartLine(productId);
//		return "redirect:/cart/show?"+response;
//	}
	
	@RequestMapping("/{cartLineId}/update")
	public String udpateCartLine(@PathVariable Long cartLineId, @RequestParam Integer count) {
		String response = this.manageCartLine(cartLineId, count);		
		return "redirect:/cart/show?"+response;		
	}
	
	@RequestMapping("/{cartLineId}/delete1")
	public String deleteCartLine(@PathVariable Long cartLineId) {
		String response = cartLineService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?"+response;
	}
	
	
	@RequestMapping("/add/{productId}/product")
	public String addCartLineq(@PathVariable Long productId) {

		String response = null;
		
		Cart cart = this.cartService.getCart();
		
		CartLine cartLine = cartLineRepository.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null)
		{
			//add cartline
			cartLine = new CartLine();
			
			//fetch product
			Product product = productService.findOne(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			cartLineService.create(cartLine);
			
			//updateCart
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartService.create(cart);
			
			response = "result=added";
		}
		else
		{
			//check if the cartLine has reached the maximum count
			if(cartLine.getProductCount() < 3)
			{
				//update the productCount for the cartLine
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount()+1);
			}
			else
			{
				response = "result=maximum";
			}
		}
		return "redirect:/cart/show?"+response;
	}
	
	public String manageCartLine(@PathVariable Long cartLineId, @RequestParam Integer count) 
	{	
		String response = null;
		
		CartLine cartLine = cartLineService.findOne(cartLineId);		

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
		cartLineService.create(cartLine);
	
		// update the cart
		Cart cart = this.cartService.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
//		cartLineDAO.updateCart(cart);
		
		cartService.create(cart);
		
		return "result=updated";
	
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String deleteCartLine1(@PathVariable Long cartLineId) {
		
		CartLine cartLine = cartLineService.findOne(cartLineId);
		if(cartLine != null)
		{
			// deduct the cart
			// update the cart
			Cart cart = cartService.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartService.update(cart);

	
			// remove the cartLine
			cartLineService.delete(cartLineId);
				
			return "redirect:/cart/show?"+"result=deleted";
		}
		else
		{
			return "redirect:/cart/show?"+"result=error";
		}
		
	}
	
	
	/* after validating it redirect to checkout
	 * if result received is success proceed to checkout 
	 * else display the message to the user about the changes in cart page
	 * */	
	@RequestMapping("/validate")
	public String validateCart() {	
		String response = cartLineService.validateCartLine();
		if(!response.equals("result=success")) {
			return "redirect:/cart/show?"+response;
		}
		else {
			return "redirect:/cart/checkout";
		}
	}	
	
	public String validateCartLine() {
		Cart cart = this.cartService.getCart();
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
		cartService.create(cart);

		return response;
	}	

}