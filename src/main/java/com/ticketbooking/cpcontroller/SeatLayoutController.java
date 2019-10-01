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

import com.ticketbooking.domain.Bus;
import com.ticketbooking.domain.LayoutType;
import com.ticketbooking.domain.SeatLayout;
import com.ticketbooking.domain.SeatType;
import com.ticketbooking.service.BusService;
import com.ticketbooking.service.LayoutTypeService;
import com.ticketbooking.service.SeatLayoutService;
import com.ticketbooking.service.SeatTypeService;

@Controller
@RequestMapping("/cp")
public class SeatLayoutController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private SeatLayoutService seatLayoutService;	
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private SeatTypeService seatTypeService;
	
	@Autowired
	private LayoutTypeService layoutTypeService;
	
	
	@RequestMapping("/all/seatLayout")
	@ResponseBody
	public List<SeatLayout> getAll() 
	{
		return seatLayoutService.findAll();
	}
	
	@RequestMapping(value = "/seatLayout", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "SeatLayout Management");
		model.addAttribute("userClickSeatLayoutManagement",true);
		
		SeatLayout nEntity = new SeatLayout();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setImage("NWS" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("seatLayout",nEntity);
			
		if(success != null && success.equals("seatLayout"))
		{
			model.addAttribute("message", "SeatLayout Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/seatLayout/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("seatLayout") SeatLayout entity,
			HttpServletRequest request)
	{
//		if(entity.getId() == 0)
//		{
			this.seatLayoutService.create(entity);
//		}
//		else
//		{
//			this.seatLayoutService.update(entity);
//		}	
		
			logger.info("Added Successfully");
			
//		if (!entity.getFile().getOriginalFilename().equals("")) {
//			FileUtil.uploadFile(request, entity.getFile(), entity.getImage());
//			
//			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
//		}
			
		return "redirect:/cp/seatLayout?success=seatLayout";
	}
	
	@RequestMapping(value ="/seatLayout/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.seatLayoutService.delete(id);
        return "redirect:/cp/seatLayout";
    }
	
	@RequestMapping("/seatLayout/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "Seat Layout Management");
		model.addAttribute("userClickSeatLayoutManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("seatLayout", this.seatLayoutService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/seatLayout/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Integer id) {		
		SeatLayout entity = seatLayoutService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		seatLayoutService.create(entity);		
		return (isActive)? "SeatLayout Dectivated Successfully!": "SeatLayout ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/seatLayout")
    public String findOne(@PathVariable Integer id, Model model) throws Exception
	{
		SeatLayout entity = this.seatLayoutService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		seatLayoutService.update(entity);
		// ---------------------------

		model.addAttribute("title", "Seat Layout Management");
		model.addAttribute("seatLayout", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "seatLayout";
	}
	
	@ModelAttribute("buses") 
	public List<Bus> modelBuses() {
		return busService.findAll();
	}
	
//	@ModelAttribute("seatTypes") 
//	public List<SeatType> modelSeatTypes() {
//		return seatTypeService.findAll();
//	}
//	
//	@ModelAttribute("layoutTypes") 
//	public List<LayoutType> modelLayoutTypes() {
//		return layoutTypeService.findAll();
//	}
	
}