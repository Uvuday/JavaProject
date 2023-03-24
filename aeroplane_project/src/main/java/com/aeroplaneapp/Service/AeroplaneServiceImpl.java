package com.aeroplaneapp.Service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import com.aeroplaneapp.Dto.AeroplaneDTO;

public class AeroplaneServiceImpl implements AeroplaneService {

	public AeroplaneServiceImpl() {
		System.out.println("Created "+this.getClass().getSimpleName()); 
	}
	
	@Override
	public Set<ConstraintViolation<AeroplaneDTO>> savaAndValiadate(AeroplaneDTO dto) {
		
		validator Validation.buildDefaultValidatorFactory();
		return null;
	}

}
