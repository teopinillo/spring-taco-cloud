package com.teopinillo.data;

import org.springframework.data.repository.CrudRepository;

import com.teopinillo.entity.Ingredient;

public interface IngredientRepository extends CrudRepository <Ingredient,String > {
	
}
