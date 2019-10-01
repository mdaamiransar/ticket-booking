package com.ticketbooking.cpcontroller;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ticketbooking.domain.Vendor;
import com.ticketbooking.service.VendorService;

@Controller
public class VendorController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private VendorService vendorService;		
	
	@RequestMapping(value = "vendor1", method = RequestMethod.GET)
	public String getAll(ModelMap model) {
		model.addAttribute("vendor", new Vendor());
		model.addAttribute("listVendor", this.vendorService.findAll());
		
		logger.info("--------------- Vendor Successfully work -------------");
		return "vendor";
	}
	
	
	@RequestMapping(value= "/vendor/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("vendorAttribute") Vendor entity)
	{
//		if(category.getId() == 0L)
//		{
			this.vendorService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
		return "redirect:/vendor1";
		
	}
	
	@RequestMapping(value ="/vendor/delete/{id}")
    public String delete(@PathVariable("id") Long id)
	{	
        this.vendorService.delete(id);
        return "redirect:/vendor1";
    }
	
	@RequestMapping(value = "vendor")
    public String edit(@RequestParam Long id, Model model, @ModelAttribute Vendor vendor)
    {	
		vendor = this.vendorService.getOne(id);
		model.addAttribute("vendor", vendor);
        model.addAttribute("listVendor", this.vendorService.findAll());
        return "vendor"; 
    }
	
}