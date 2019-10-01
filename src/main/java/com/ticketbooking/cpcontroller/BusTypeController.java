package com.ticketbooking.cpcontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.ticketbooking.domain.BusType;
import com.ticketbooking.exception.ProductNotFoundException;
import com.ticketbooking.repository.BusRepository;
import com.ticketbooking.service.BusTypeService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class BusTypeController 
{   	
//	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private BusTypeService busTypeService;		
	
	@RequestMapping("/all/busType")
	@ResponseBody
	public List<BusType> getAll() {
		
		return busTypeService.findAll();
		
		//return busRepository.findLast4ProductById(true);
		
		//return busRepository.findActiveBus(true);//working
				
	}
	
	@RequestMapping(value = "/busType", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "BusType Management");
		model.addAttribute("userClickBusTypeManagement",true);
		
		BusType nEntity = new BusType();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setUnitPrice(256.0);
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("busType", nEntity);
		
		
		if(success != null && success.equals("busType"))
		{
			model.addAttribute("message", "BusType Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/busType/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("busType") BusType entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.busTypeService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
//			logger.info("Added Successfully");
			
		return "redirect:/cp/busType?success=busType";
		
	}
	
	@RequestMapping(value ="/busType/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.busTypeService.delete(id);
        return "redirect:/cp/busType";
    }
	
	@RequestMapping("/busType/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "BusType Management");
		model.addAttribute("userClickBusTypeManagement", true);

		// BusType nProduct = new BusType();
		model.addAttribute("busType", this.busTypeService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/busType/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostBusActivation(@PathVariable Integer id) {		
		BusType entity = busTypeService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		busTypeService.create(entity);		
		return (isActive)? "BusType Dectivated Successfully!": "BusType Activated Successfully";
	}
	
	
	
	/*
	 * Viewing a single product
	 * */
//	@RequestMapping(value = "/show/{id}/product")
//    public String findOne(@PathVariable Long id, Model model) throws ProductNotFoundException
//	{
//		BusType entity = this.busTypeService.getOne(id);
//
//		if (entity == null) throw new ProductNotFoundException();
//
//		// update the view count
//		entity.setViews(entity.getViews() + 1);
//		busTypeService.update(entity);
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