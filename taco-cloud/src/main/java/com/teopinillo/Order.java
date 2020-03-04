package com.teopinillo;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.util.Date;
import lombok.Data;

@Data
public class Order {
	
	private Long ID;
	private Date placedAt;

	@NotBlank (message="Name is requiered")
	private String name;
	
	@NotBlank (message="Street is requiered")
	private String street;
	
	@NotBlank (message="City is requiered")
	private String city;
	
	@NotBlank (message="State is requiered")
	private String state;
	
	@NotBlank (message="Zip code is requiered")
	private String zip;
	
	@CreditCardNumber (message="Not a valid credit card number")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
			message="Must be formatted MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;
	
}
