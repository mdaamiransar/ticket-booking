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

import com.ticketbooking.domain.SettingDetails;
import com.ticketbooking.exception.ProductNotFoundException;
import com.ticketbooking.repository.BusRepository;
import com.ticketbooking.service.SettingDetailsService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class SettingDetailsController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private SettingDetailsService settingDetailsService;		
	
	@Autowired
	private BusRepository busRepository;
	
	@RequestMapping("/all/settingDetails")
	@ResponseBody
	public List<SettingDetails> getAll() {
		
		return settingDetailsService.findAll();
		
		//return busRepository.findLast4ProductById(true);
		
		//return busRepository.findActiveBus(true);//working
				
	}
	
	@RequestMapping(value = "/settingDetails", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "SettingDetails Management");
		model.addAttribute("userClickSettingDetailsManagement",true);
		
		SettingDetails nEntity = new SettingDetails();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setUnitPrice(256.0);
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("settingDetails", nEntity);
		
		
		if(success != null && success.equals("settingDetails"))
		{
			model.addAttribute("message", "SettingDetails Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/settingDetails/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("settingDetails") SettingDetails entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.settingDetailsService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
		if (!entity.getLogo().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, entity.getLogo(), entity.getCode());
			
			logger.info("File Added Successfully" + entity.getLogo().getOriginalFilename());
		}
		
		if (!entity.getFavicon().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, entity.getFavicon(), entity.getCode());
			
			logger.info("File Added Successfully" + entity.getFavicon().getOriginalFilename());
		}
			
		return "redirect:/cp/settingDetails?success=settingDetails";
		
	}
	
	@RequestMapping(value ="/settingDetails/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.settingDetailsService.delete(id);
        return "redirect:/cp/settingDetails";
    }
	
	@RequestMapping("/settingDetails/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "SettingDetails Management");
		model.addAttribute("userClickSettingDetailsManagement", true);

		// SettingDetails nProduct = new SettingDetails();
		model.addAttribute("settingDetails", this.settingDetailsService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/settingDetails/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostBusActivation(@PathVariable Integer id) {		
		SettingDetails entity = settingDetailsService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		settingDetailsService.create(entity);		
		return (isActive)? "SettingDetails Dectivated Successfully!": "SettingDetails Activated Successfully";
	}
	
	
	
	/*
	 * Viewing a single product
	 * */
//	@RequestMapping(value = "/show/{id}/product")
//    public String findOne(@PathVariable Long id, Model model) throws ProductNotFoundException
//	{
//		SettingDetails entity = this.settingDetailsService.getOne(id);
//
//		if (entity == null) throw new ProductNotFoundException();
//
//		// update the view count
//		entity.setViews(entity.getViews() + 1);
//		settingDetailsService.update(entity);
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