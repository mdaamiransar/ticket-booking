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

import com.ticketbooking.domain.Testimonial;
import com.ticketbooking.service.TestimonialService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class TestimonialController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private TestimonialService testimonialService;	
	
	@RequestMapping("/all/testimonial")
	@ResponseBody
	public List<Testimonial> getAllProducts() 
	{
		return testimonialService.findAll();
	}
	
	@RequestMapping(value = "/testimonial", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Testimonial Management");
		model.addAttribute("userClickTestimonialManagement",true);
		
		Testimonial nEntity = new Testimonial();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		nEntity.setImage("TST" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("testimonial",nEntity);
			
		if(success != null && success.equals("testimonial"))
		{
			model.addAttribute("message", "Testimonial Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/testimonial/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("testimonial") Testimonial entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.testimonialService.create(entity);
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
			
		return "redirect:/cp/testimonial?success=testimonial";
	}
	
	@RequestMapping(value ="/testimonial/delete/{id}")
    public String delete(@PathVariable("id") Long id)
	{	
        this.testimonialService.delete(id);
        return "redirect:/cp/testimonial";
    }
	
	@RequestMapping("/testimonial/{id}")
	public String edit(@PathVariable Long id, Model model) 
	{
		model.addAttribute("title", "Testimonial Management");
		model.addAttribute("userClickTestimonialManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("testimonial", this.testimonialService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/testimonial/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostActivation(@PathVariable Long id) {		
		Testimonial entity = testimonialService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		testimonialService.create(entity);		
		return (isActive)? "Testimonial Dectivated Successfully!": "Testimonial ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/testimonial")
    public String findOne(@PathVariable Long id, Model model) throws Exception
	{
		Testimonial entity = this.testimonialService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		testimonialService.update(entity);
		// ---------------------------

		model.addAttribute("title", entity.getName());
		model.addAttribute("news", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "news";
	}
	
}