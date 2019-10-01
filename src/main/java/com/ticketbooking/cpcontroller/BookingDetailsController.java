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

import com.ticketbooking.domain.BookingDetails;
import com.ticketbooking.service.BookingDetailsService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class BookingDetailsController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private BookingDetailsService bookingDetailsService;	
	
	@RequestMapping("/all/bookingDetails")
	@ResponseBody
	public List<BookingDetails> getAll() 
	{
		logger.info(bookingDetailsService.findAll());
		return bookingDetailsService.findAll();
	}
	
	@RequestMapping(value = "/bookingDetails", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "BookingDetails Management");
		model.addAttribute("userClickBookingDetailsManagement",true);
		
		BookingDetails nEntity = new BookingDetails();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
//		nEntity.setImage("ABT" + UUID.randomUUID().toString().substring(26).toUpperCase());
//		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("bookingDetails",nEntity);
			
		if(success != null && success.equals("bookingDetails"))
		{
			model.addAttribute("message", "BookingDetails Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/bookingDetails/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("bookingDetails") BookingDetails entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.bookingDetailsService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
			
		return "redirect:/cp/bookingDetails?success=bookingDetails";
	}
	
	@RequestMapping(value ="/bookingDetails/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.bookingDetailsService.delete(id);
        return "redirect:/cp/bookingDetails";
    }
	
	@RequestMapping("/bookingDetails/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "BookingDetails Management");
		model.addAttribute("userClickBookingDetailsManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("bookingDetails", this.bookingDetailsService.findOne(id));

		return "cp/page";

	}
	
//	@RequestMapping(value = "/bookingDetails/{id}/activation", method=RequestMethod.GET)
//	@ResponseBody
//	public String managePostAbouttActivation(@PathVariable Integer id) {		
//		BookingDetails entity = bookingDetailsService.findOne(id);
//		Boolean isActive = entity.getStatus();
//		entity.setStatus(!isActive);
//		bookingDetailsService.create(entity);		
//		return (isActive)? "BookingDetails Dectivated Successfully!": "BookingDetails ID Activated Successfully";
//	}
	
//	@RequestMapping(value = "/show/{id}/bookingDetails")
//    public String findOne(@PathVariable Integer id, Model model) throws Exception
//	{
//		BookingDetails entity = this.bookingDetailsService.findOne(id);
//
//		if (entity == null) throw new Exception();
//
//		// update the view count
//		entity.setViews(entity.getViews() + 1);
//		bookingDetailsService.update(entity);
//		// ---------------------------
//
//		model.addAttribute("title", "bookingDetails");
//		model.addAttribute("bookingDetails", entity);
//
//		//mv.addObject("userClickShowProduct", true);
//		
//		return "bookingDetails";
//	}
	
}