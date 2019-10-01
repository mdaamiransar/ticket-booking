package com.ticketbooking.cpcontroller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ticketbooking.domain.BoardPoint;
import com.ticketbooking.domain.Bus;
import com.ticketbooking.domain.Route;
import com.ticketbooking.service.BoardPointService;
import com.ticketbooking.service.BusService;
import com.ticketbooking.service.RouteService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class BoardPointController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private BoardPointService boardPointService;	
	
	@Autowired
	private BusService busService;	
	
	@Autowired
	private RouteService routeService;	
	
//	@RequestMapping(value="/all/boardPoint", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@RequestMapping("/all/boardPoint")
	@ResponseBody
	public List<BoardPoint> getAll() 
	{
		return boardPointService.findAll();
	}
	
	@RequestMapping(value = "/boardPoint", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "BoardPoint Management");
		model.addAttribute("userClickBoardPointManagement",true);
		
		BoardPoint nEntity = new BoardPoint();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setImage("NWS" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("boardPoint",nEntity);
			
		if(success != null && success.equals("boardPoint"))
		{
			model.addAttribute("message", "BoardPoint Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/boardPoint/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("boardPoint") BoardPoint entity,
			HttpServletRequest request)
	{
//		if(entity.getId() == 0)
//		{
			this.boardPointService.create(entity);
//		}
//		else
//		{
//			this.boardPointService.update(entity);
//		}	
		
			logger.info("Added Successfully");
			
//		if (!entity.getFile().getOriginalFilename().equals("")) {
//			FileUtil.uploadFile(request, entity.getFile(), entity.getImage());
//			
//			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
//		}
			
		return "redirect:/cp/boardPoint?success=boardPoint";
	}
	
	@RequestMapping(value ="/boardPoint/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.boardPointService.delete(id);
        return "redirect:/cp/boardPoint";
    }
	
	@RequestMapping("/boardPoint/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "BoardPoint Management");
		model.addAttribute("userClickBoardPointManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("boardPoint", this.boardPointService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/boardPoint/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Integer id) {		
		BoardPoint entity = boardPointService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		boardPointService.create(entity);		
		return (isActive)? "BoardPoint Dectivated Successfully!": "BoardPoint ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/boardPoint")
    public String findOne(@PathVariable Integer id, Model model) throws Exception
	{
		BoardPoint entity = this.boardPointService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		boardPointService.update(entity);
		// ---------------------------

		model.addAttribute("title", "Board Point");
		model.addAttribute("boardPoint", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "boardPoint";
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