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

import com.ticketbooking.domain.About;
import com.ticketbooking.service.AboutService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class DashboardController 
{   	
	protected static Logger logger = Logger.getLogger("controller");

	
	@RequestMapping(value = {"/", "/dashboard"})
	public String getDashboard(Model model) 
	{
		model.addAttribute("title", "Dashboard Management");
		model.addAttribute("userClickDashboardManagement", true);
		
		return "cp/page";

	}
}