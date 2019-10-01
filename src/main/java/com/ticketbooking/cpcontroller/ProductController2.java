package com.ticketbooking.cpcontroller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.ticketbooking.domain.Product;
import com.ticketbooking.exception.ProductNotFoundException;
import com.ticketbooking.repository.ProductRepository;
import com.ticketbooking.service.ProductService;
import com.ticketbooking.util.FileUtil;

@Controller
//@RequestMapping("/cp")
public class ProductController2 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private ProductService productService;		
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@RequestMapping("/show/{id}/product")
    public String showSingleProduct(@PathVariable Long id, Model model)throws ProductNotFoundException
	{
		Product product = productService.findOne(id);
		
		if (product == null) throw new ProductNotFoundException();
		
		//update views
		product.setViews(product.getViews() + 1);
		productService.update(product);
		
		model.addAttribute("title", product.getName());
		model.addAttribute("userClickShowProduct", true);
		model.addAttribute("product", product);
		
        return "page";
    }
	
}