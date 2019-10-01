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

import com.ticketbooking.domain.Promo;
import com.ticketbooking.service.PromoService;

@Controller
@RequestMapping("/cp")
public class PromoController 
{   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private PromoService promoService;	
	
	@RequestMapping("/all/promo")
	@ResponseBody
	public List<Promo> getAll() 
	{
		return promoService.findAll();
	}
	
	@RequestMapping(value = "/promo", method = RequestMethod.GET)
	public String findAll(@RequestParam(name="success", required=false) String success, ModelMap model) {
		
		model.addAttribute("title", "Promo Management");
		model.addAttribute("userClickPromoManagement",true);
		
		Promo nEntity = new Promo();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		//nEntity.setImage("NWS" + UUID.randomUUID().toString().substring(26).toUpperCase());
		nEntity.setStatus(true);
		nEntity.setCreatedBy("admin");
		nEntity.setCreatedDate(new Date().toString());
		nEntity.setModifiedBy("admin");
		nEntity.setModifiedDate(new Date().toString());
		
		model.addAttribute("promo",nEntity);
			
		if(success != null && success.equals("promo"))
		{
			model.addAttribute("message", "Promo Submitted Successfully");
		}
		
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/promo/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("promo") Promo entity,
			HttpServletRequest request)
	{
//		if(entity.getId() == 0)
//		{
			this.promoService.create(entity);
//		}
//		else
//		{
//			this.promoService.update(entity);
//		}	
		
			logger.info("Added Successfully");
			
//		if (!entity.getFile().getOriginalFilename().equals("")) {
//			FileUtil.uploadFile(request, entity.getFile(), entity.getImage());
//			
//			logger.info("File Added Successfully" + entity.getFile().getOriginalFilename());
//		}
			
		return "redirect:/cp/promo?success=promo";
	}
	
	@RequestMapping(value ="/promo/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
	{	
        this.promoService.delete(id);
        return "redirect:/cp/promo";
    }
	
	@RequestMapping("/promo/{id}")
	public String edit(@PathVariable Integer id, Model model) 
	{
		model.addAttribute("title", "Promo Management");
		model.addAttribute("userClickPromoManagement", true);

		// Product nProduct = new Product();
		model.addAttribute("promo", this.promoService.findOne(id));

		return "cp/page";

	}
	
	@RequestMapping(value = "/promo/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostAbouttActivation(@PathVariable Integer id) {		
		Promo entity = promoService.findOne(id);
		Boolean isActive = entity.getStatus();
		entity.setStatus(!isActive);
		promoService.create(entity);		
		return (isActive)? "Promo Dectivated Successfully!": "Promo ID Activated Successfully";
	}
	
	@RequestMapping(value = "/show/{id}/promo")
    public String findOne(@PathVariable Integer id, Model model) throws Exception
	{
		Promo entity = this.promoService.findOne(id);

		if (entity == null) throw new Exception();

		// update the view count
		entity.setViews(entity.getViews() + 1);
		promoService.update(entity);
		// ---------------------------

		model.addAttribute("title", "Promo Management");
		model.addAttribute("promo", entity);

		//mv.addObject("userClickShowProduct", true);
		
		return "promo";
	}
	
}