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

import com.ticketbooking.domain.Amenities;
import com.ticketbooking.domain.Bus;
import com.ticketbooking.domain.BusType;
import com.ticketbooking.domain.City;
import com.ticketbooking.domain.LayoutType;
import com.ticketbooking.domain.Route;
import com.ticketbooking.domain.SeatType;
import com.ticketbooking.exception.ProductNotFoundException;
import com.ticketbooking.repository.BusRepository;
import com.ticketbooking.repository.CityRepository;
import com.ticketbooking.service.AmenitiesService;
import com.ticketbooking.service.BusService;
import com.ticketbooking.service.BusTypeService;
import com.ticketbooking.service.CityService;
import com.ticketbooking.service.LayoutTypeService;
import com.ticketbooking.service.SeatLayoutService;
import com.ticketbooking.service.SeatTypeService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class BusController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private BusService busService;	
	
	@Autowired
	private BusRepository busRepository;
	
	@Autowired
	private BusTypeService busTypeService;	
	
	@Autowired
	private SeatTypeService seatTypeService;
	
	@Autowired
	private LayoutTypeService layoutTypeService;
	
	@Autowired
	private AmenitiesService amenitiesService;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/all/bus")
	@ResponseBody
	public List<Bus> getAll() {
		
		return busService.findAll();
		
		//return busRepository.findLast4ProductById(true);
		
		//return busRepository.findActiveBus(true);//working
				
	}
	
	@RequestMapping(value = "/bus", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Bus Management");
		model.addAttribute("userClickBusManagement",true);
		
		Bus nEntity = new Bus();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setUnitPrice(256.0);
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("bus", nEntity);
		
		
		if(success != null && success.equals("bus"))
		{
			model.addAttribute("message", "Bus Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/bus/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("bus") Bus entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.busService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
		if (!entity.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, entity.getFile(), entity.getCode());
			
			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
		}
			
		return "redirect:/cp/bus?success=bus";
		
	}
	
	@RequestMapping(value ="/bus/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.busService.delete(id);
        return "redirect:/cp/bus";
    }
	
	@RequestMapping("/bus/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "Bus Management");
		model.addAttribute("userClickBusManagement", true);

		// Bus nProduct = new Bus();
		model.addAttribute("bus", this.busService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/bus/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostBusActivation(@PathVariable Integer id) {		
		Bus entity = busService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		busService.create(entity);		
		return (isActive)? "Bus Dectivated Successfully!": "Bus Activated Successfully";
	}
	
	
	
	/*
	 * Viewing a single product
	 * */
//	@RequestMapping(value = "/show/{id}/product")
//    public String findOne(@PathVariable Long id, Model model) throws ProductNotFoundException
//	{
//		Bus entity = this.busService.getOne(id);
//
//		if (entity == null) throw new ProductNotFoundException();
//
//		// update the view count
//		entity.setViews(entity.getViews() + 1);
//		busService.update(entity);
//		// ---------------------------
//
//		model.addAttribute("title", entity.getName());
//		model.addAttribute("product", entity);
//
//		//mv.addObject("userClickShowProduct", true);
//		
//		return "product";
//	}
	
	@ModelAttribute("busTypes") 
	public List<BusType> getBusType() {
        
        List<BusType> busTypesList = busTypeService.findAll();
		return busTypesList;
	}
	
	@ModelAttribute("seatTypes") 
	public List<SeatType> getSeatTypes() {
		return seatTypeService.findAll();
	}
	
	@ModelAttribute("layoutTypes") 
	public List<LayoutType> getLayoutTypes() {
		return layoutTypeService.findAll();
	}
	
	@ModelAttribute("amenities") 
	public List<Amenities> getAmenities() {
		return amenitiesService.findAll();
	}
	
	@ModelAttribute("cities") 
	public List<City> getCities() {
		return cityService.findAll();
	}
	
	@ModelAttribute("decks") 
	public List<Integer> getDecks() {	
		 
		return findAllDecks();
	}
	
	public List<Integer> findAllDecks() {
		
		List<Integer> decks = new ArrayList<Integer>();
        //add key-value pair to hashmap
		decks.add(1);
		decks.add(2);
        
		return decks;
	}
	
	@RequestMapping(value = "/findCity", method = RequestMethod.GET, headers="Accept=*/*")
	public @ResponseBody List<String> findNameFromCity(@RequestParam("term") String query) 
	{
		List<String> cityList = getCityList(query);
		return cityList;
	}
	
	public List<String> getCityList(String query) {
    	
    	String country = null;
        query = query.toLowerCase();
        
        List<String> dropPointList = cityRepository.findNameFromCity(query);
        
        List<String> matched = new ArrayList<String>();
        
        for(int i=0; i < dropPointList.size(); i++) {
            country = dropPointList.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(dropPointList.get(i));
            }
        }
        return matched;
    }

	
//	Static Values For Testing
//	@ModelAttribute("busTypes") 
//	public List<String> modelBusType() {
//		
//		HashMap<Integer, String> busTypesHashMap = new HashMap<Integer, String>();
//        //add key-value pair to hashmap
//		busTypesHashMap.put(1, "AC Sleeper");
//		busTypesHashMap.put(2, "Non-AC Sleeper");
//		busTypesHashMap.put(3, "AC Seater");
//		busTypesHashMap.put(4, "Non-AC Seater");
//        
//        List<String> busTypesList = new ArrayList<String>(busTypesHashMap.values());
//		return busTypesList;
//	}
	
}