package com.example.demo.parts;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.user.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Controller
public class PartsController {

	@Autowired
	private PartsService partsservice;
	
	@GetMapping("/parts")
	public String showParts(HttpServletRequest request,Model model) {
    	User user = (User) request.getSession().getAttribute("sessionUser");
    	
    	if(user == null ) {
    		return "redirect:/login";
    	}
    	
    	List<Parts> parts;
    	parts =  partsservice.findAllParts();
    	model.addAttribute("role", user.getRole());
    	model.addAttribute("username",user.getUsername());
    	model.addAttribute("parts", parts);
    	model.addAttribute("user", user);
    	
    	return "parts";
    	
	}
	@PostMapping("add-part")
	public String addPart(HttpServletRequest request,Model model) {
		User user = (User) request.getSession().getAttribute("sessionUser");
    	
    	if(user == null ) {
    		return "redirect:/login";
    	}
    	String inputSku = request.getParameter("sku");
    	String inputCategory = request.getParameter("category");
    	String inputPartName = request.getParameter("partName");
    	String inputPrice = request.getParameter("basePrice");
    	Integer inputStock = Integer.parseInt(request.getParameter("stock"));
    	Integer inputThreshold = Integer.parseInt(request.getParameter("threshold"));
    	Parts part = new Parts();
    	
    	part.setBasePrice(inputPrice);
    	part.setCategory(inputCategory);
    	part.setPartName(inputPartName);
    	part.setSku(inputSku);
    	part.setStock(inputStock);
    	part.setThreshold(inputThreshold);
    	
    	partsservice.addPart(part);
    	
    	return "redirect:/parts";
    	
	}
	
	@GetMapping("/inventory")
	public String inventory(HttpServletRequest request, Model model) {

	    User user = (User) request.getSession().getAttribute("sessionUser");

	    if(user == null) {
	        return "redirect:/login";
	    }

	    String keyword = request.getParameter("keyword");

	    List<Parts> parts;

	    if(keyword == null || keyword.trim().isEmpty()) {

	        parts = partsservice.findAllParts();

	    } else {

	        parts = partsservice.searchParts(keyword);

	    }
	    long lowStockCount = parts.stream()
	            .filter(p ->
	            p.getStock() != null &&
	            p.getThreshold() != null &&
	            p.getStock() <= p.getThreshold()
	        )
	        .count();
	            
	    model.addAttribute("lowStockCount", lowStockCount);
	    model.addAttribute("parts", parts);
	    model.addAttribute("keyword", keyword);

	    model.addAttribute("user", user);
	    model.addAttribute("username", user.getUsername());
	    model.addAttribute("role", user.getRole());

	    return "inventory";
	}
	
	
}