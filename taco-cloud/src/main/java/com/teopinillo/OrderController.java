package com.teopinillo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping ("/orders")
public class OrderController {
	

	
	/*
	 * When the processOrder() method is called to handle a submitted order, it’s given an
		Order object whose properties are bound to the submitted form fields. Order, much
		like Taco, is a fairly straightforward class that carries order information.
	 */
	@PostMapping
	public String processOrder(Order order) {
		log.info("Order submitted: " + order);
		return "redirect:/"; 	//indicates a redirect view. It indicates that after processingDesign() completes,
								//, the user's browser should be redirected to the relative path 
								// /order/current
		}
			
	@GetMapping("/current")			// get -> orders/current
    public String    				// the web page
    orderForm (Model model) {
		model.addAttribute("order", //order will be the object
				new Order());       // the object
		return "orderForm";         //the web page name
	}
	
	
}
