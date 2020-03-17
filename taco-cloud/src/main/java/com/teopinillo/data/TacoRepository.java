package com.teopinillo.data;

import org.springframework.data.repository.CrudRepository;

import com.teopinillo.Taco;

public interface TacoRepository extends CrudRepository <Taco,Long >{	
	
}
