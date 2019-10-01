package com.ticketbooking.cpcontroller;

import java.util.List;

//import org.apache.log4j.Logger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.domain.About;
import com.ticketbooking.service.AboutService;

@RestController
public class ResttController1 {
	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private AboutService aboutService;

	/*@RequestMapping(value = "/about-us", method = RequestMethod.GET)
	@ResponseBody
	public List<About> getAll1() {

		logger.info("Open Successfully");

		return this.aboutService.findAll();
	}
*/
	@GetMapping("/1")
	public String home() {
		return "Spring REST Dinesh on Java!!!";
	}

	@GetMapping("/about-us")
	public List<About> all() {
		return aboutService.findAll();
	}

	@PostMapping("/about")
	public Boolean create(@RequestBody About account) {
		return aboutService.create(account);
	}

	@GetMapping("/about/{id}")
	public About get(@PathVariable Long id) {
		return aboutService.findOne(id);
	}

	@PutMapping("/about/{id}")
	public Boolean update(@RequestBody About account, @PathVariable Long id) {
		return aboutService.create(account);
	}

	@DeleteMapping("/about/{id}")
	public void delete(@PathVariable Long id) {
		aboutService.delete(id);
	}

}