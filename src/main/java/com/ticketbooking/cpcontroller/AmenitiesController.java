package com.ticketbooking.cpcontroller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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

import com.ticketbooking.domain.Amenities;
import com.ticketbooking.service.AmenitiesService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class AmenitiesController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private AmenitiesService amenitiesService;	
	
	@RequestMapping("/all/amenities")
	@ResponseBody
	public List<Amenities> getAll() 
	{
		return amenitiesService.findAll();
	}
	
	@RequestMapping(value = "/amenities", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Amenities Management");
		model.addAttribute("userClickAmenitiesManagement",true);
		
		Amenities nEntity = new Amenities();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setImage("NWS" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("amenities",nEntity);
			
		if(success != null && success.equals("amenities"))
		{
			model.addAttribute("message", "Amenities Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/amenities/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("amenities") Amenities entity,
			HttpServletRequest request)
	{
//		if(entity.getId() == 0)
//		{
			this.amenitiesService.create(entity);
//		}
//		else
//		{
//			this.amenitiesService.update(entity);
//		}	
		
			logger.info("Added Successfully");
			
		if (!entity.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, entity.getFile(), entity.getCode());
			
			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
		}
			
		return "redirect:/cp/amenities?success=amenities";
	}
	
	@RequestMapping(value ="/amenities/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.amenitiesService.delete(id);
        return "redirect:/cp/amenities";
    }
	
	@RequestMapping("/amenities/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "Amenities Management");
		model.addAttribute("userClickAmenitiesManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("amenities", this.amenitiesService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/amenities/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Integer id) {		
		Amenities entity = amenitiesService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		amenitiesService.create(entity);		
		return (isActive)? "Amenities Dectivated Successfully!": "Amenities ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/amenities")
    public String findOne(@PathVariable Integer id, Model model) throws Exception
	{
		Amenities entity = this.amenitiesService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		amenitiesService.update(entity);
		// ---------------------------

		model.addAttribute("title", "Amenities Management");
		model.addAttribute("amenities", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "amenities";
	}
	
}