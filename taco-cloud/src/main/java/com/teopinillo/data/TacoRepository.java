package com.teopinillo.data;

import org.springframework.data.repository.CrudRepository;

import com.teopinillo.entity.Taco;

public interface TacoRepository extends CrudRepository <Taco,Long >{	
	
}
