package com.teopinillo;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class Taco {
	
	private Long id;
	private Date createdAt;
	
@NotNull
@Size (min=5, message="Name must be at least 5 characters long")
private String name;
//Field error in object 'taco' on field 'ingredients': rejected value [FLTO,CARN,CHED,TMTO,SRCR]; 
//codes [typeMismatch.taco.ingredients,typeMismatch.ingredients,typeMismatch.java.util.List,typeMismatch]; 
//arguments [org.springframework.context.support.DefaultMessageSourceResolvable: 
//codes [taco.ingredients,ingredients]; arguments []; default message [ingredients]]; 
//default message [Failed to convert property value of type 'java.lang.String[]' to 
//required type 'java.util.List' for property 'ingredients'; 
//nested exception is java.lang.IllegalStateException: 
//Cannot convert value of type 'java.lang.String' to required type 'com.teopinillo.Ingredient' 
//for property 'ingredients[0]': no matching editors or conversion strategy found]]
//
//private List<Ingredient> ingredients;
@Size(min=1, message="You must choose at least 1 ingredient")
private List<Ingredient> ingredients;
}
