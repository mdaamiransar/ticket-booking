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

import com.ticketbooking.domain.City;
import com.ticketbooking.service.CityService;

@Controller
@RequestMapping("/cp")
public class CityController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private CityService cityService;		
	
	@RequestMapping("/all/city")
	@ResponseBody
	public List<City> getAll() {
		
		return cityService.findAll();
				
	}
	
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "City Management");
		model.addAttribute("userClickCityManagement",true);
		
		City nEntity = new City();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setUnitPrice(256.0);
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("city", nEntity);
		
		
		if(success != null && success.equals("city"))
		{
			model.addAttribute("message", "City Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/city/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("city") City entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.cityService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
		return "redirect:/cp/city?success=city";
		
	}
	
	@RequestMapping(value ="/city/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.cityService.delete(id);
        return "redirect:/cp/city";
    }
	
	@RequestMapping("/city/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "City Management");
		model.addAttribute("userClickCityManagement", true);

		// City nProduct = new City();
		model.addAttribute("city", this.cityService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/city/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostBusActivation(@PathVariable Integer id) {		
		City entity = cityService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		cityService.create(entity);		
		return (isActive)? "City Dectivated Successfully!": "City Activated Successfully";
	}
	
	
	
	/*
	 * Viewing a single product
	 * */
//	@RequestMapping(value = "/show/{id}/product")
//    public String findOne(@PathVariable Long id, Model model) throws ProductNotFoundException
//	{
//		City entity = this.cityService.getOne(id);
//
//		if (entity == null) throw new ProductNotFoundException();
//
//		// update the view count
//		entity.setViews(entity.getViews() + 1);
//		cityService.update(entity);
//		// ---------------------------
//
//		model.addAttribute("title", entity.getName());
//		model.addAttribute("product", entity);
//
//		//mv.addObject("userClickShowProduct", true);
//		
//		return "product";
//	}
	
}