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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.teopinillo.Ingredient.Type;
import com.teopinillo.data.IngredientRepository;
import lombok.extern.slf4j.*;


@Slf4j   //Lombok-provided annotation that, at runtime, will automatically generate and SLF4J (Single logging Facade
//for Java, https://www.slf4j.org/) Logger in the class.
@Controller
//Identify this class as a Controller and to mark it as a candidate for component scanning, so that Spring will discover it
//and automatically create an instance of DesignTacoController as a bean in the Spring application context.
@RequestMapping ("/design")  //specifies the kind of request that this controller handles. (whose path begins with /design)
@SessionAttributes("order")
public class DesignTacoController {

	/*
	 * The class-level @RequestMapping specification is refined with the @GetMapping annotation that adorns the
	 * showDesignForm() method. 
	 * @GetMapping, paired with the class level @RequestMapping, specifies that when an HTTP GET request is received
	 * for /design, showDesignForm() will be called to handle the request.
	 */
	
	//@GetMapping	
	//Model is an object that ferries data between a controller and whatever view is charged with rendering that data.
	//Ultimately, data that's placed in Model attributes is copied into the servlet request attributes, 
	//where the view can find them
	//
	/*
	public String showDessignForm (Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient ("FLTO", "Flour Tortilla",Type.WRAP),
				new Ingredient ("COTO", "Corn Tortilla",Type.WRAP),
				new Ingredient ("GRBF", "Ground Beef",Type.PROTEIN),
				new Ingredient ("CARN", "Carnitas",Type.PROTEIN),
				new Ingredient ("TMTO", "Diced Tomatoes",Type.VEGGIES),
				new Ingredient ("LETC", "Lettuce",Type.VEGGIES),
				new Ingredient ("CHED", "Cheddar",Type.CHEESE),
				new Ingredient ("JACK", "Monterry Jack",Type.CHEESE),
				new Ingredient ("SRCR", "Sour Cream",Type.SAUCE));
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), 
					filterByType(ingredients,type));			
		}
		model.addAttribute("design", new Taco());
		//"design" is the logical name of the view that will be used to render the model to the browser
		return "design";
	}
	*/
	
	//filters the list by ingredient 
	private List<Ingredient> filterByType (List <Ingredient> ingredients, Type type) {
		 return ingredients
				 .stream()
				 .filter(x -> x.getType().equals(type))
				 .collect(Collectors.toList());
	}	
	
	
	@PostMapping
	//handle a POST request from /design
	public String processDesign (@Valid Taco design, Errors errors) {
		if (errors.hasErrors()) {
			return "design";
		}
		//Save the taco design
		//TODO: implemented on chapter 3
		return "redirect:/orders/current";
	}
	
	//With JdbcIngredientRepository complete, we can inject it, and use it to provide a list of
	//Ingredients objects instead of using hardcoded values (as line 37 and forward ).
	private final IngredientRepository ingredientRepo;
	
	@Autowired
	public DesignTacoController (IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@GetMapping
	public String showDesignForm (Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute (type.toString().toLowerCase(),
					filterByType(ingredients, type));
		}
		//this line was omitted in the example and the app crash
		model.addAttribute("design", new Taco());
		return "design";
	}
	
	
	
	
}
