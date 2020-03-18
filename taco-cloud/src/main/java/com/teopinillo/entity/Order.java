package com.teopinillo.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table (name="Taco_Order")
public class Order {
	
	private static final long serialVersionUUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long ID;
	
	private Date placedAt;

	@NotBlank (message="Name is requiered")
	private String name;
	
	@NotBlank (message="Street is requiered")
	private String street;
	
	@NotBlank (message="City is requiered")
	private String deliveryCity;
	
	@NotBlank (message="State is requiered")
	private String state;
	
	@NotBlank (message="Zip code is requiered")
	private String deliveryZip;
	
	@CreditCardNumber (message="Not a valid credit card number")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
			message="Must be formatted MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;
	
	@ManyToMany (targetEntity = Taco.class)
	private List<Taco> tacos = new ArrayList<>();
	
	public void addDesign(Taco design) {
		this.tacos.add(design);
	}
	
	@PrePersist
	void placedAt() {
		this.placedAt = new Date();
	}
	
}
