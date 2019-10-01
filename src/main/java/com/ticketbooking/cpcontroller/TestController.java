package com.ticketbooking.cpcontroller;

import java.util.List;

import org.jboss.logging.Logger;
//import org.apache.log4j.Logger;
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
import org.springframework.web.servlet.ModelAndView;

import com.ticketbooking.domain.About;
import com.ticketbooking.domain.Category;
import com.ticketbooking.service.AboutService;
import com.ticketbooking.service.CategoryService;

@Controller
@RequestMapping("/cp")
public class TestController {
   	
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private CategoryService categoryService;		
	
	
//	Frontend UI Code
	
//	ControlPanel UI Code
	
	@RequestMapping("/all/test")
	@ResponseBody
	public List<Category> getAllProducts() {
		
		return categoryService.findAll();
				
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getAll(ModelMap model) {
		
		model.addAttribute("title", "Test Modal");
		model.addAttribute("userClickTestModal", true);
		
		model.addAttribute("category", new Category());
		//model.addAttribute("listVendor", this.categoryService.findAll());
		
		logger.info(" Category Page Working");
		return "cp/page";
	}
	
	
	@RequestMapping(value= "/test/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("category") Category entity)
	{
		/*if (entity.getId() == 0L) {*/
			this.categoryService.create(entity);
		/*} else {
			this.categoryService.update(entity);
		}*/

		return "redirect:/cp/test";

	}
	
	@RequestMapping(value ="/test/delete/{id}")
    public String delete(@PathVariable("id") Long id)
	{	
        this.categoryService.delete(id);
        return "redirect:/cp/test";
    }
	
	@RequestMapping("/{id}/test1")
    public String edit(@PathVariable Long id, Model model)
    {	
		logger.debug(".....ID....." + id);
		//vendor = this.categoryService.getOne(id);
		model.addAttribute("category", this.categoryService.getOne(id));
		
		model.addAttribute("title", "Category");
		model.addAttribute("userClickCategory", true);
		
        //model.addAttribute("listVendor", this.categoryService.findAll());
        return "cp/page"; 
    }
	
	@RequestMapping("/test/{id}")
	public ModelAndView manageProductEdit(@PathVariable Long id) {		

		ModelAndView mv = new ModelAndView("cp/page");	
		mv.addObject("title","Test Modal");		
		mv.addObject("userClickTestModal",true);
		
		// Product nProduct = new Product();		
		mv.addObject("category", this.categoryService.getOne(id));

			
		return mv;
		
	}
	
}