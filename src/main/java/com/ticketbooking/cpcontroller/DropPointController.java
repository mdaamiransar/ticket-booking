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

import com.ticketbooking.domain.Bus;
import com.ticketbooking.domain.DropPoint;
import com.ticketbooking.domain.Route;
import com.ticketbooking.service.BusService;
import com.ticketbooking.service.DropPointService;
import com.ticketbooking.service.RouteService;

@Controller
@RequestMapping("/cp")
public class DropPointController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private DropPointService dropPointService;	
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private RouteService routeService;
	
	@RequestMapping("/all/dropPoint")
	@ResponseBody
	public List<DropPoint> getAll() 
	{
		return dropPointService.findAll();
	}
	
	@RequestMapping(value = "/dropPoint", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "DropPoint Management");
		model.addAttribute("userClickDropPointManagement",true);
		
		DropPoint nEntity = new DropPoint();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setImage("NWS" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("dropPoint",nEntity);
			
		if(success != null && success.equals("dropPoint"))
		{
			model.addAttribute("message", "DropPoint Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/dropPoint/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("dropPoint") DropPoint entity,
			HttpServletRequest request)
	{
//		if(entity.getId() == 0)
//		{
			this.dropPointService.create(entity);
//		}
//		else
//		{
//			this.dropPointService.update(entity);
//		}	
		
			logger.info("Added Successfully");
			
//		if (!entity.getFile().getOriginalFilename().equals("")) {
//			FileUtil.uploadFile(request, entity.getFile(), entity.getImage());
//			
//			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
//		}
			
		return "redirect:/cp/dropPoint?success=dropPoint";
	}
	
	@RequestMapping(value ="/dropPoint/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.dropPointService.delete(id);
        return "redirect:/cp/dropPoint";
    }
	
	@RequestMapping("/dropPoint/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "DropPoint Management");
		model.addAttribute("userClickDropPointManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("boardPoint", this.dropPointService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/dropPoint/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Integer id) {		
		DropPoint entity = dropPointService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		dropPointService.create(entity);		
		return (isActive)? "DropPoint Dectivated Successfully!": "DropPoint ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/dropPoint")
    public String findOne(@PathVariable Integer id, Model model) throws Exception
	{
		DropPoint entity = this.dropPointService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		dropPointService.update(entity);
		// ---------------------------

		model.addAttribute("title", "Drop Point");
		model.addAttribute("dropPoint", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "dropPoint";
	}
	
	@ModelAttribute("buses") 
	public List<Bus> modelBuses() {
		return busService.findAll();
	}
	
	@ModelAttribute("routes") 
	public List<Route> modelRoutes() {
		return routeService.findAll();
	}
	
}