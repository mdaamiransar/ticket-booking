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

import com.ticketbooking.domain.Customer;
import com.ticketbooking.service.CustomerService;

@Controller
@RequestMapping("/cp")
public class CustomerController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private CustomerService customerService;	
	
	@RequestMapping("/all/customer")
	@ResponseBody
	public List<Customer> getAll() 
	{
		return customerService.findAll();
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Customer Management");
		model.addAttribute("userClickCustomerManagement",true);
		
		Customer nEntity = new Customer();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setImage("NWS" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("customer",nEntity);
			
		if(success != null && success.equals("customer"))
		{
			model.addAttribute("message", "Customer Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/customer/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("customer") Customer entity,
			HttpServletRequest request)
	{
//		if(entity.getId() == 0)
//		{
			this.customerService.create(entity);
//		}
//		else
//		{
//			this.customerService.update(entity);
//		}	
		
			logger.info("Added Successfully");
			
//		if (!entity.getFile().getOriginalFilename().equals("")) {
//			FileUtil.uploadFile(request, entity.getFile(), entity.getImage());
//			
//			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
//		}
			
		return "redirect:/cp/customer?success=customer";
	}
	
	@RequestMapping(value ="/customer/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.customerService.delete(id);
        return "redirect:/cp/customer";
    }
	
	@RequestMapping("/customer/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "Customer Management");
		model.addAttribute("userClickCustomerManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("customer", this.customerService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/customer/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Integer id) {		
		Customer entity = customerService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		customerService.create(entity);		
		return (isActive)? "Customer Dectivated Successfully!": "Customer ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/customer")
    public String findOne(@PathVariable Integer id, Model model) throws Exception
	{
		Customer entity = this.customerService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		customerService.update(entity);
		// ---------------------------

		model.addAttribute("title", "Customer Management");
		model.addAttribute("customer", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "customer";
	}
	
}