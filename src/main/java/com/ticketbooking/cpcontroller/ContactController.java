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

import com.ticketbooking.domain.Contact;
import com.ticketbooking.service.ContactService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class ContactController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private ContactService contactService;	
	
	@RequestMapping("/all/contact")
	@ResponseBody
	public List<Contact> getAll() 
	{
		return contactService.findAll();
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Contact Management");
		model.addAttribute("userClickContactManagement",true);
		
		Contact nEntity = new Contact();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		nEntity.setImage("CON" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("contact",nEntity);
			
		if(success != null && success.equals("contact"))
		{
			model.addAttribute("message", "Contact Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/contact/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("contact") Contact entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.contactService.create(entity);
//		}
		/*else
		{
			this.categoryService.update(category);
		}	*/
		
			logger.info("Added Successfully");
			
		if (!entity.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, entity.getFile(), entity.getImage());
			
			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
		}
			
		return "redirect:/cp/contact?success=contact";
	}
	
	@RequestMapping(value ="/contact/delete/{id}")
    public String delete(@PathVariable("id") Long id)
	{	
        this.contactService.delete(id);
        return "redirect:/cp/contact";
    }
	
	@RequestMapping("/contact/{id}")
	public String edit(@PathVariable Long id, Model model) 
	{
		model.addAttribute("title", "Contact Management");
		model.addAttribute("userClickContactManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("contact", this.contactService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/contact/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Long id) {		
		Contact entity = contactService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		contactService.create(entity);		
		return (isActive)? "Contact Dectivated Successfully!": "Contact ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/contact")
    public String findOne(@PathVariable Long id, Model model) throws Exception
	{
		Contact entity = this.contactService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		contactService.update(entity);
		// ---------------------------

		model.addAttribute("title", entity.getName());

		//mv.addObject("userClickShowProduct", true);
		
		return "contact";
	}
	
}