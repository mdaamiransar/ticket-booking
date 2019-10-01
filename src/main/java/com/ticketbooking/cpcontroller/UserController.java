package com.ticketbooking.cpcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ticketbooking.domain.User;
import com.ticketbooking.service.UserService;

@Controller
//@SessionAttributes("username")
public class UserController 
{   	
//	protected static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;		
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		
		return "cp/dashboard";
	}
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String getAll(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUser", this.userService.findAll());
		return "user";
	}
	
	
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
//	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("userAttribute") User entity)
	{
//		if(category.getId() == 0L)
//		{
			this.userService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
		return "redirect:/users";
		
	}
	
	//@RequestMapping("/user/delete/{id}")
	//@RequestMapping(value ="/delete/{id}")
	@RequestMapping(value ="/user/delete/{id}")
    public String delete(@PathVariable("id") Long id)
	{	
        this.userService.delete(id);
        return "redirect:/users";
    }
	
	@RequestMapping(value = "user")
    public String edit(@RequestParam Long id, Model model, @ModelAttribute User user)
    {	
		user = this.userService.getOne(id);
		model.addAttribute("user", user);
        model.addAttribute("listUser", this.userService.findAll());
        return "user"; 
    }
	
	// GET: Show Login Page
    @RequestMapping(value = "/login")
    public String login(ModelMap model, @RequestParam(name = "error", required = false) String error,
    		@RequestParam(name="logout", required = false) String logout) {
 
    	model.addAttribute("title", "Login");
    	
    	if(error != null)
    	{
    		model.addAttribute("message", "Username and Password is invalid!");
    	}
    	
    	if(logout != null)
    	{
    		model.addAttribute("logout", "You have logged out successfully!");
    	}
        return "login";
    }
    
    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	
//    	if(auth != null)
//    	{
//    		new SecurityContextLogoutHandler().logout(request, response, auth);
//    	}
    	
    	return "redirect:/login?logout";
    }
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Alert !! There is Error");
		mv.addObject("errorDescription", "You are not authorized to view this page");
		
		return mv;
	}
}