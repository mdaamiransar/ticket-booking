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
import org.springframework.web.servlet.ModelAndView;

import com.ticketbooking.domain.Bus;
import com.ticketbooking.domain.Route;
import com.ticketbooking.service.BusService;
import com.ticketbooking.service.RouteService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class RouteController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private BusService busService;
	
	@RequestMapping("/all/route")
	@ResponseBody
	public List<Route> getAll() 
	{
		return routeService.findAll();
	}
	
	@RequestMapping(value = "/route", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Route Management");
		model.addAttribute("userClickRouteManagement",true);
		
		Route nEntity = new Route();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setImage("ABT" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("route",nEntity);
			
		if(success != null && success.equals("route"))
		{
			model.addAttribute("message", "Route Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/route/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("route") Route entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.routeService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
		return "redirect:/cp/route?success=route";
	}
	
	@RequestMapping(value ="/route/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.routeService.delete(id);
        return "redirect:/cp/route";
    }
	
	@RequestMapping("/route/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "Route Management");
		model.addAttribute("userClickRouteManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("route", this.routeService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/route/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Integer id) {		
		Route entity = routeService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		routeService.create(entity);		
		return (isActive)? "Route Dectivated Successfully!": "Route ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/route")
    public String findOne(@PathVariable Integer id, Model model) throws Exception
	{
		Route entity = this.routeService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		routeService.update(entity);
		// ---------------------------

		model.addAttribute("title", "Route Management");
		model.addAttribute("route", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "route";
	}

	@ModelAttribute("buses") 
	public List<Bus> modelBuses() {
		return busService.findAll();
	}
	
}