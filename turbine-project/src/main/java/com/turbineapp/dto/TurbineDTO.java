package com.turbineapp.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurbineDTO {

	@Id
	private int id;
	
	@Size(min = 4 , max = 20 , message = "Company Name should be greater than 4 and less than 20")
	private String companyName;
	 
	@NotNull(message = "Cost should not be null")
	private Double cost; 
	
	@NotBlank(message = "Type should not be blank")
	private String type;
	
	@NotBlank(message = "Country should not be blank")
	private String country;

}
 