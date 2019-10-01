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
@RequestMapping("/cp")
public class ProductController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private ProductService productService;		
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/show")
    public String show()
	{	
        return "sProduct";
    }
	
	@RequestMapping("/all/product")
	@ResponseBody
	public List<Product> getAllProducts() {
		
//		return productService.findAll();
		
		return productRepository.findLast4ProductById(true);
		
//		return productRepository.findActiveProducts(true);//working
				
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Product Management");
		model.addAttribute("userClickManageProduct",true);
		
		Product nEntity = new Product();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setUnitPrice(256.0);
		nEntity.setGst(18.0);
		nEntity.setSupplierId(1);
		nEntity.setCategoryId(1);
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("product",nEntity);
		
		
		if(success != null && success.equals("product"))
		{
			model.addAttribute("message", "Product Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("product") Product entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.productService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
		if (!entity.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, entity.getFile(), entity.getCode());
			
			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
		}
			
		return "redirect:/cp/product?success=product";
		
	}
	
	@RequestMapping(value ="/product/delete/{id}")
    public String delete(@PathVariable("id") Long id)
	{	
        this.productService.delete(id);
        return "redirect:/cp/product";
    }
	
	@RequestMapping("/product/{id}")
	public String edit(@PathVariable Long id, Model model) 
	{
		model.addAttribute("title", "Product Management");
		model.addAttribute("userClickManageProduct", true);

		// Product nProduct = new Product();
		model.addAttribute("product", this.productService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostProductActivation(@PathVariable Long id) {		
		Product product = productService.findOne(id);
		Boolean isActive = product.getStatus();
		product.setStatus(!isActive);
		productService.create(product);		
		return (isActive)? "Product Dectivated Successfully!": "Product Activated Successfully";
	}
	
	/*
	 * Viewing a single product
	 * */
//	@RequestMapping(value = "/show/{id}/product")
//    public String findOne(@PathVariable Long id, Model model) throws ProductNotFoundException
//	{
//		Product entity = this.productService.getOne(id);
//
//		if (entity == null) throw new ProductNotFoundException();
//
//		// update the view count
//		entity.setViews(entity.getViews() + 1);
//		productService.update(entity);
//		// ---------------------------
//
//		model.addAttribute("title", entity.getName());
//		model.addAttribute("product", entity);
//
//		//mv.addObject("userClickShowProduct", true);
//		
//		return "product";
//	}
	
//	@ModelAttribute("categories")
//	public List<Category> getCategories()
//	{
//		return categoryService.findAll();
//	}
	
	
	
}