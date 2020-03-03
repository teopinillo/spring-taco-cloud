package com.teopinillo;

import java.util.List;
import lombok.Data;

@Data
public class Taco {
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
private List<String> ingredients;
}
