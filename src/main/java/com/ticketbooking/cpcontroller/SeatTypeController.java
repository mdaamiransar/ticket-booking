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

import com.ticketbooking.domain.Bus;
import com.ticketbooking.domain.SeatType;
import com.ticketbooking.exception.ProductNotFoundException;
import com.ticketbooking.repository.BusRepository;
import com.ticketbooking.service.SeatTypeService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class SeatTypeController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private SeatTypeService seatTypeService;		
	
	@RequestMapping("/all/seatType")
	@ResponseBody
	public List<SeatType> getAll() {
		
		return seatTypeService.findAll();
		
		//return busRepository.findLast4ProductById(true);
		
		//return busRepository.findActiveBus(true);//working
				
	}
	
	@RequestMapping(value = "/seatType", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "SeatType Management");
		model.addAttribute("userClickSeatTypeManagement",true);
		
		SeatType nEntity = new SeatType();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setUnitPrice(256.0);
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("seatType", nEntity);
		
		
		if(success != null && success.equals("seatType"))
		{
			model.addAttribute("message", "SeatType Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/seatType/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("seatType") SeatType entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.seatTypeService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
		return "redirect:/cp/seatType?success=seatType";
		
	}
	
	@RequestMapping(value ="/seatType/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.seatTypeService.delete(id);
        return "redirect:/cp/seatType";
    }
	
	@RequestMapping("/seatType/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "SeatType Management");
		model.addAttribute("userClickSeatTypeManagement", true);

		// SeatType nProduct = new SeatType();
		model.addAttribute("seatType", this.seatTypeService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/seatType/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostBusActivation(@PathVariable Integer id) {		
		SeatType entity = seatTypeService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		seatTypeService.create(entity);		
		return (isActive)? "SeatType Dectivated Successfully!": "SeatType Activated Successfully";
	}
	
	
	
	/*
	 * Viewing a single product
	 * */
//	@RequestMapping(value = "/show/{id}/product")
//    public String findOne(@PathVariable Long id, Model model) throws ProductNotFoundException
//	{
//		SeatType entity = this.seatTypeService.getOne(id);
//
//		if (entity == null) throw new ProductNotFoundException();
//
//		// update the view count
//		entity.setViews(entity.getViews() + 1);
//		seatTypeService.update(entity);
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