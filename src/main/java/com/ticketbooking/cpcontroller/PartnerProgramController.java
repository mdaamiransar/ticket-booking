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

import com.ticketbooking.domain.PartnerProgram;
import com.ticketbooking.service.PartnerProgramService;
import com.ticketbooking.util.FileUtil;

@Controller
@RequestMapping("/cp")
public class PartnerProgramController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private PartnerProgramService partnerProgramService;	
	
	@RequestMapping("/all/partnerProgram")
	@ResponseBody
	public List<PartnerProgram> getAllProducts() 
	{
		return partnerProgramService.findAll();
	}
	
	@RequestMapping(value = "/partnerProgram", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Partners Program Management");
		model.addAttribute("userClickPartnerProgramManagement",true);
		
		PartnerProgram nEntity = new PartnerProgram();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		nEntity.setImage("PP" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("partnerProgram",nEntity);
			
		if(success != null && success.equals("partnerProgram"))
		{
			model.addAttribute("message", "PartnerProgram Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/partnerProgram/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("partnerProgram") PartnerProgram entity,
			HttpServletRequest request)
	{
//		if(category.getId() == 0L)
//		{
		
		
			this.partnerProgramService.create(entity);
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
			
		return "redirect:/cp/partnerProgram?success=partnerProgram";
	}
	
	@RequestMapping(value ="/partnerProgram/delete/{id}")
    public String delete(@PathVariable("id") Long id)
	{	
        this.partnerProgramService.delete(id);
        return "redirect:/cp/partnerProgram";
    }
	
	@RequestMapping("/partnerProgram/{id}")
	public String edit(@PathVariable Long id, Model model) 
	{
		model.addAttribute("title", "Partners Program Management");
		model.addAttribute("userClickPartnerProgramManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("partnerProgram", this.partnerProgramService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/partnerProgram/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Long id) {		
		PartnerProgram entity = partnerProgramService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		partnerProgramService.create(entity);		
		return (isActive)? "PartnerProgram Dectivated Successfully!": "PartnerProgram ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/partnerProgram")
    public String findOne(@PathVariable Long id, Model model) throws Exception
	{
		PartnerProgram entity = this.partnerProgramService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		partnerProgramService.update(entity);
		// ---------------------------

		model.addAttribute("title", entity.getName());
		model.addAttribute("partnerProgram", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "partnerProgram";
	}
	
}