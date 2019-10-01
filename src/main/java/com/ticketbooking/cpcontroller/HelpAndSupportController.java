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

import com.ticketbooking.domain.HelpAndSupport;
import com.ticketbooking.service.HelpAndSupportService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class HelpAndSupportController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private HelpAndSupportService helpAndSupportService;	
	
	@RequestMapping("/all/helpAndSupport")
	@ResponseBody
	public List<HelpAndSupport> getAll() 
	{
		logger.info(helpAndSupportService.findAll());
		return helpAndSupportService.findAll();
	}
	
	@RequestMapping(value = "/helpAndSupport", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "HelpAndSupport Management");
		model.addAttribute("userClickHelpAndSupportManagement",true);
		
		HelpAndSupport nEntity = new HelpAndSupport();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		nEntity.setImage("ABT" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("helpAndSupport",nEntity);
			
		if(success != null && success.equals("helpAndSupport"))
		{
			model.addAttribute("message", "HelpAndSupport Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/helpAndSupport/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("helpAndSupport") HelpAndSupport entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.helpAndSupportService.create(entity);
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
			
		return "redirect:/cp/helpAndSupport?success=helpAndSupport";
	}
	
	@RequestMapping(value ="/helpAndSupport/delete/{id}")
    public String delete(@PathVariable("id") Long id)
	{	
        this.helpAndSupportService.delete(id);
        return "redirect:/cp/helpAndSupport";
    }
	
	@RequestMapping("/helpAndSupport/{id}")
	public String edit(@PathVariable Long id, Model model) 
	{
		model.addAttribute("title", "HelpAndSupport Management");
		model.addAttribute("userClickHelpAndSupportManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("helpAndSupport", this.helpAndSupportService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/helpAndSupport/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Long id) {		
		HelpAndSupport entity = helpAndSupportService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		helpAndSupportService.create(entity);		
		return (isActive)? "HelpAndSupport Dectivated Successfully!": "HelpAndSupport ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/helpAndSupport")
    public String findOne(@PathVariable Long id, Model model) throws Exception
	{
		HelpAndSupport entity = this.helpAndSupportService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		helpAndSupportService.update(entity);
		// ---------------------------

		model.addAttribute("title", entity.getName());
		model.addAttribute("helpAndSupport", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "helpAndSupport";
	}
	
}