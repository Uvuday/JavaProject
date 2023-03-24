package com.aeroplaneapp.Service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.aeroplaneapp.Dto.AeroplaneDTO;

public interface AeroplaneService { 
	
	Set<ConstraintViolation<AeroplaneDTO>> savaAndValiadate(AeroplaneDTO dto);
	

}
