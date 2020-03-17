package com.teopinillo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sun.tools.sjavac.Log;
import com.teopinillo.Ingredient.Type;
import com.teopinillo.data.IngredientRepository;
import com.teopinillo.data.TacoRepository;

import lombok.extern.slf4j.*;


@Slf4j
@Controller
@RequestMapping ("/design")  //specifies the kind of request that this controller handles. (whose path begins with /design)
@SessionAttributes("order")
public class DesignTacoController {
	
	
	private final IngredientRepository ingredientRepo;
	private TacoRepository designRepo;
		
	@Autowired
	public DesignTacoController (IngredientRepository ingredientRepo,
								TacoRepository designRepo) {
		this.ingredientRepo = ingredientRepo;
		this.designRepo = designRepo;
	}
	
	@ModelAttribute (name = "order")
	public Order order() {
		return new Order();
	}
	
	@ModelAttribute (name = "design")
	public Taco design() {
		return new Taco();
	}
	
	@GetMapping
	public String showDesignForm (Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			log.info("Type found:" + type.toString().toLowerCase());
			model.addAttribute (type.toString().toLowerCase(),
					filterByType(ingredients, type));
		}		
		return "design";
	}
	
	@PostMapping  //handle a POST request from /design
	public String processDesign (@Valid Taco taco, Errors errors, @ModelAttribute Order order) {
		if (errors.hasErrors()) {
			return "design";
		}
		
		Taco saved = designRepo.save(taco);
		order.addDesign(saved);
		
		log.info("Processing design: " + taco);
		return "redirect:/orders/current";
	}
	
	
	//filters the list by ingredient 
	private List<Ingredient> filterByType (List <Ingredient> ingredients, Type type) {
		 return ingredients
				 .stream()
				 .filter(x -> x.getType().equals(type))
				 .collect(Collectors.toList());
	}
	
	
}
