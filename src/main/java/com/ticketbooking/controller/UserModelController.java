package com.ticketbooking.controller;

import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ticketbooking.domain.User;
import com.ticketbooking.domain.UserModel;
import com.ticketbooking.service.UserService;

@Controller
public class UserModelController {
	protected static Logger logger = Logger.getLogger(UserModelController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	private UserModel userModel = null;

	private User user = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
//		if (session.getAttribute("userModel") == null) {
//			
//			// get the authentication object
//			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//			if (!authentication.getPrincipal().equals("anonymousUser")) {
//				// get the user from the database
//				user = userService.findByUsername(authentication.getName());
//				
//				logger.info("------- Username :"+user.getUsername() + "-- Cart : "  + user.getCart());
//				logger.debug("------- Username :"+user.getUsername() + "-- Cart : "  + user.getCart());
//
//				if (user != null) {
//					
//					// create a new model
//					userModel = new UserModel();
//					// set the name and the id
//					userModel.setId(user.getId());
//					userModel.setFullName(user.getFirstName() + " " + user.getLastName());
//					userModel.setRole(user.getRole());
//
//					if (user.getRole().equals("USER")) {
//						userModel.setCart(user.getCart());
//					}
//
//					session.setAttribute("userModel", userModel);
//					return userModel;
//				}
//			}
//		}

		return (UserModel) session.getAttribute("userModel");
	}
}