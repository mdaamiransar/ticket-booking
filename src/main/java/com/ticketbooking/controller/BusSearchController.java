package com.ticketbooking.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.ServerProperties.Session.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ticketbooking.domain.Amenities;
import com.ticketbooking.domain.BoardPoint;
import com.ticketbooking.domain.Bus;
import com.ticketbooking.domain.Category;
import com.ticketbooking.domain.DropPoint;
import com.ticketbooking.domain.Route;
import com.ticketbooking.domain.SeatLayout;
import com.ticketbooking.domain.Vendor;
import com.ticketbooking.repository.BoardPointRepository;
import com.ticketbooking.repository.BusRepository;
import com.ticketbooking.repository.DropPointRepository;
import com.ticketbooking.repository.RouteRepository;
import com.ticketbooking.repository.SeatLayoutRepository;
import com.ticketbooking.service.BoardPointService;
import com.ticketbooking.service.BusService;
import com.ticketbooking.service.CartLineService;
import com.ticketbooking.service.CartService;
import com.ticketbooking.service.CategoryService;
import com.ticketbooking.service.RouteService;
import com.ticketbooking.service.SeatLayoutService;
import com.ticketbooking.util.SeatLayoutHelper;
import com.ticketbooking.validator.SeatCountValidator;
import com.ticketbooking.vo.TravelersForm;

@Controller
public class BusSearchController 
{
   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private SeatCountValidator seatCountValidator;
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private RouteService routeService;	
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private BusRepository busRepository;
	
	@Autowired
	private BoardPointRepository boardPointRepository  ;
	
	@Autowired
	private DropPointRepository dropPointRepository;
	
	@Autowired
	private SeatLayoutRepository seatLayoutRepository;
	
	@Autowired
	private SeatLayoutService seatLayoutService;
	
	
	@InitBinder
    private void initBinder(WebDataBinder binder) {
		binder.setValidator(seatCountValidator);
    } 
	
	
//	@Autowired
//	private SeatLayoutHelper seatLayoutHelper;
	
	@PostMapping(value = "/success")
	public String index(ModelMap model, TravelersForm passengers) 
	{
		logger.warn("heeeeeeeeeeeeeeee :: "+passengers.getPassengers());
		logger.warn("heeeeeeeeeeeeeeee ::" +passengers.getPassengerContact());		

		model.addAttribute("title", "Online Bus");
		
		model.addAttribute("orderId", "ORD1000321");
		
		double totalFare =0.0;
		
		for(int i=0; i<passengers.getPassengers().size(); i++)
		{
			totalFare += passengers.getPassengers().get(i).getSeat().getFare();
		}
		
		model.addAttribute("totalFare", totalFare);
		
		model.addAttribute("passengers", passengers.getPassengers());
		
		model.addAttribute("passengerContact", passengers.getPassengerContact());
		
		model.addAttribute("userClickSuccess", true);
		
		return "masterPage";
	}
	
//	@RequestMapping("/bus/{busId}/seatLayout")
//	@ResponseBody
//	public String findSeatLayoutByBus(@PathVariable Integer busId, Model model) 
//	{
//		List<SeatLayout> busSeatLayout =  seatLayoutRepository.findSeatLayoutByBus(busId);
//	
////		model.addAttribute("busSeatStructure", seatLayoutHelper.Redbus_BuildOnWordSeatsLayout_backup(busSeatLayout));		
//		
//		SeatLayoutHelper seatLayoutHelper = new SeatLayoutHelper();
//		
//		return seatLayoutHelper.Redbus_BuildOnWordSeatsLayout_backup(busSeatLayout);
//	}
	
	
//	@RequestMapping(value="/show-layout/{bus}")
//	public String showSeatLayout(ModelMap model, @PathVariable("bus") Integer busId){
//		Map<String, SeatLayout[][]> berthWiseSeats = seatLayoutService.loadSeatLayout(busId);
//		model.addAttribute("lBerth", berthWiseSeats.get("L-BERTH"));
//		if(berthWiseSeats.containsKey("U-BERTH")){
//			model.addAttribute("uBerth", berthWiseSeats.get("U-BERTH"));
//		}
//		model.addAttribute("berthSize" , berthWiseSeats.keySet().size());
//		return "berthWiseSeats";
//	}
		
	@RequestMapping(value="/check_avail/{bus}")
	//@ResponseBody
	public String checkAvailability(ModelMap model, @PathVariable("bus") Integer busId)
	{
		Map<String, SeatLayout[][]> berthWiseSeats = seatLayoutService.loadSeatLayout(busId);
		logger.warn(" testing  rows >> "+ ((SeatLayout[][])berthWiseSeats.get("L-BERTH")).length );
		logger.warn("test cols>>>>> "+ ((SeatLayout[][])berthWiseSeats.get("L-BERTH"))[0].length);
		model.addAttribute("lBerth", berthWiseSeats.get("L-BERTH"));
		if(berthWiseSeats.containsKey("U-BERTH")){
			model.addAttribute("uBerth", berthWiseSeats.get("U-BERTH"));
		}
		Map<Integer, String> boardings = boardPointRepository.loadBoardings(busId).stream().collect(Collectors.toMap(BoardPoint::getId, BoardPoint::getBoardingPoint));
		Map<Integer, String> dropings =dropPointRepository.loadDropings(busId).stream().collect(Collectors.toMap(DropPoint::getId, DropPoint::getDroppingPoint));
		logger.warn("boardings   ------------- "+boardings);
		logger.warn("dropings   ------------- "+dropings);
		model.addAttribute("boardings", boardings);
		
		model.addAttribute("dropings", dropings);
		model.addAttribute("berthSize" , berthWiseSeats.keySet().size());
		model.addAttribute("travelersForm", new TravelersForm());
		return "berthWiseSeats";

	}
	
	@RequestMapping(value="/seatNo/{name}")
	@ResponseBody
	public String getSeat(@PathVariable("name") String seatName)
	{
		try
		{
			System.out.println("seatName :: "+ seatName);
			
//			System.out.println("seatName :: "+ seatLayoutRepository.findBySeatName(seatName).getBus());
//			System.out.println("seatName :: "+ seatLayoutRepository.findBySeatName(seatName).getBaseFare());
//			return seatLayoutRepository.findBySeatName(seatName);
			return seatName;
			
		}
		catch(Exception e) {
			
//			return "ERROR : KINDLY CHECK YOUR CODE";
			return null;
		}
	}
	
	@ModelAttribute("bp")
	   public Map<Integer, String> getCountryList() {
	      Map<Integer, String> countryList = new HashMap<Integer, String>();
	      countryList.put(1, "United States");
	      countryList.put(2, "China");
	      countryList.put(3, "Singapore");
	      countryList.put(4, "Malaysia");
	      return countryList;
	   }
}