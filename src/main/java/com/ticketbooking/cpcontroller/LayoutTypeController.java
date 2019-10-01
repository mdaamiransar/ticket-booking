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

import com.ticketbooking.domain.LayoutType;
import com.ticketbooking.exception.ProductNotFoundException;
import com.ticketbooking.repository.BusRepository;
import com.ticketbooking.service.LayoutTypeService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class LayoutTypeController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private LayoutTypeService layoutTypeService;		
	
	@RequestMapping("/all/layoutType")
	@ResponseBody
	public List<LayoutType> getAll() {
		
		return layoutTypeService.findAll();
		
		//return busRepository.findLast4ProductById(true);
		
		//return busRepository.findActiveBus(true);//working
				
	}
	
	@RequestMapping(value = "/layoutType", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "LayoutType Management");
		model.addAttribute("userClickLayoutTypeManagement",true);
		
		LayoutType nEntity = new LayoutType();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setUnitPrice(256.0);
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("layoutType", nEntity);
		
		
		if(success != null && success.equals("layoutType"))
		{
			model.addAttribute("message", "LayoutType Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/layoutType/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("layoutType") LayoutType entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.layoutTypeService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
		return "redirect:/cp/layoutType?success=layoutType";
		
	}
	
	@RequestMapping(value ="/layoutType/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.layoutTypeService.delete(id);
        return "redirect:/cp/layoutType";
    }
	
	@RequestMapping("/layoutType/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "LayoutType Management");
		model.addAttribute("userClickLayoutTypeManagement", true);

		// LayoutType nProduct = new LayoutType();
		model.addAttribute("layoutType", this.layoutTypeService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/layoutType/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostBusActivation(@PathVariable Integer id) {		
		LayoutType entity = layoutTypeService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		layoutTypeService.create(entity);		
		return (isActive)? "LayoutType Dectivated Successfully!": "LayoutType Activated Successfully";
	}
	
	
	
	/*
	 * Viewing a single product
	 * */
//	@RequestMapping(value = "/show/{id}/product")
//    public String findOne(@PathVariable Long id, Model model) throws ProductNotFoundException
//	{
//		LayoutType entity = this.layoutTypeService.getOne(id);
//
//		if (entity == null) throw new ProductNotFoundException();
//
//		// update the view count
//		entity.setViews(entity.getViews() + 1);
//		layoutTypeService.update(entity);
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