package com.ticketbooking.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ticketbooking.domain.Bus;
import com.ticketbooking.domain.Category;
import com.ticketbooking.domain.DropPoint;
import com.ticketbooking.domain.Route;
import com.ticketbooking.domain.Vendor;
import com.ticketbooking.repository.BusRepository;
import com.ticketbooking.repository.RouteRepository;
import com.ticketbooking.service.BoardPointService;
import com.ticketbooking.service.BusService;
import com.ticketbooking.service.CartLineService;
import com.ticketbooking.service.CartService;
import com.ticketbooking.service.CategoryService;
import com.ticketbooking.service.RouteService;

@Controller
public class HomeController 
{
   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private RouteService routeService;	
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private BusRepository busRepository;
	
	@RequestMapping(value = {"/", "/index"})
	public String getIndexPage(ModelMap model) {

		model.addAttribute("title", "Online Bus Booking");
		model.addAttribute("userClickHome", true);
		
		return "masterPage";
	}
	
	// Searching using PathVariable -> some need to be asked
	@RequestMapping(value = "/searchBus/{boardPoint}/{dropPoint}")
	public String searchBus(ModelMap model, @PathVariable("boardPoint") String boardPoint, 
			@PathVariable("dropPoint") String dropPoint) {
			
		dropPoint = dropPoint.replaceAll(",$", "");

		List<Bus> busList = busRepository.findBusesByRoute(boardPoint, dropPoint);
		
		model.addAttribute("title", "Bus Search");
		model.addAttribute("userClickSearchBuses", true);
		
		model.addAttribute("listBus", busList);
		
		return "masterPage";
	}
	
	@RequestMapping(value = "/search" , method = RequestMethod.GET)
	public String searchB(ModelMap model, 
			@RequestParam(value="boardPoint", required = false) String boardPoint,
			@RequestParam String dropPoint,
			@RequestParam(value="departureDate", required = false) String departureDate,
			@RequestParam(value="returnDate", required = false) String returnDate) {
		
		dropPoint = dropPoint.replaceAll(",$", "");
//		List<Route> busesList = routeRepository.findBusesByRoute(boardPoint, dropPoint);
		List<Bus> busList = busRepository.findBusesByRoute(boardPoint, dropPoint);
		
		logger.info("********************* "+ busList);
		
		model.addAttribute("title", "Bus Search");
		model.addAttribute("userClickSearchBuses", true);
		
		model.addAttribute("listBus", busList);
		
		return "masterPage";
	}
	
//	Retrieving using Spring Annotation Code - Not needed right now - Below done the same thing using better approach using json
	
//	@ModelAttribute("buses") 
//	public List<Bus> modelBuses() {
//		return busService.findAll();
//	}
//	
//	@ModelAttribute("routes") 
//	public List<Route> modelRoutes() {
//		return routeService.findAll();
//	}
//	
//	@RequestMapping("/findRoutes")
//	@ResponseBody
//	public List<Route> findBoardPointFromRoute() 
//	{
//		return routeRepository.findAll();
//	}
	
	@RequestMapping(value = "/findBoardPoint", method = RequestMethod.GET, headers="Accept=*/*")
	public @ResponseBody List<String> findBoardPointFromRoute(@RequestParam("term") String query) 
	{
//		List<String> dropPointList = routeRepository.findDropPointFromRoute();
		List<String> dropPointList = getBPList(query);
		return dropPointList;
	}
	
	@RequestMapping(value = "/findDropPoint", method = RequestMethod.GET, headers="Accept=*/*")
	public @ResponseBody List<String> findDropPointFromRoute(@RequestParam("term") String query) 
	{
//		List<String> dropPointList = routeRepository.findDropPointFromRoute();
		List<String> dropPointList = getDPList(query);
		return dropPointList;
	}
	
public List<String> getBPList(String query) {
    	
    	String country = null;
        query = query.toLowerCase();
        
        List<String> dropPointList = routeRepository.findBoardPointFromRoute(query);
        
        List<String> matched = new ArrayList<String>();
        
        for(int i=0; i < dropPointList.size(); i++) {
            country = dropPointList.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(dropPointList.get(i));
            }
        }
        return matched;
    }

	public List<String> getDPList(String query) {
    	
    	String country = null;
        query = query.toLowerCase();
        
        List<String> dropPointList = routeRepository.findDropPointFromRoute(query);
        
        List<String> matched = new ArrayList<String>();
        
        for(int i=0; i < dropPointList.size(); i++) {
            country = dropPointList.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(dropPointList.get(i));
            }
        }
        return matched;
    }
}