package com.ticketbooking.cpcontroller;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelperController {
	protected static Logger logger = Logger.getLogger("controller");

	@RequestMapping(value = "/index-2", method = RequestMethod.GET)
	public String getAll(ModelMap model) {
		model.addAttribute("title", "Home");
		model.addAttribute("userClickHome", true);
		
		logger.info("Open Successfully");
		
		return "cp/page";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(ModelMap model) {
		model.addAttribute("title", "Dashboard");
		model.addAttribute("userClickDashboard", true);
		
		logger.info("Open Successfully");
		
		return "page";
	}
	
	@RequestMapping(value = "/cp/dashboard", method = RequestMethod.GET)
	public String cpDashboard(ModelMap model) {
		model.addAttribute("title", "Dashboard");
		model.addAttribute("userClickDashboardCP", true);
		
		logger.info("Open Successfully");
		
		return "cp/page";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String displayAbout(Model model) {
		model.addAttribute("title", "About");
		model.addAttribute("userClickAbout", true);
		
		logger.info("About Page Working");
		
		return "cp/page";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String displayContact(Model model) {
		model.addAttribute("title", "Contact");
		model.addAttribute("userClickContact", true);
		
		logger.info("Open Successfully");
		
		return "cp/page";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String displayProduct(Model model) {
		model.addAttribute("title", "Product");
		model.addAttribute("userClickProduct", true);
		
		logger.info("Open Successfully");
		
		return "cp/page";
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String displayDownload(Model model) {
		model.addAttribute("title", "Download");
		model.addAttribute("userClickDownload", true);
		
		logger.info("Open Successfully");
		
		return "cp/page";
	}
	
}