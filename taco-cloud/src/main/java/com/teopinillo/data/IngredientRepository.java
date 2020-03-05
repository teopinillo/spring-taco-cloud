package com.teopinillo.data;

import com.teopinillo.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll();

	Ingredient findOne(String id);

	Ingredient save(Ingredient ingredinet);
}
