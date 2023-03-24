package com.aeroplaneapp.Dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AeroplaneDTO {
	
	@Id
	private int id;
    @Size(min = 3 , max = 20 , message = "Company should be greater than 3 and less than 20")
    private String company;
    @Size(min = 3 , max = 20 , message = "Name should be greater than 3 and less than 20")
    private String name;
    @NotNull(message = "cost should not be null")
    private Double cost;
    @NotBlank(message = "country should not be null")
    private String country;
    
    

}