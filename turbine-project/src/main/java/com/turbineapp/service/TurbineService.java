package com.turbineapp.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.turbineapp.dto.TurbineDTO;

public interface TurbineService {

	Set<ConstraintViolation<TurbineDTO>> saveAndValidate(TurbineDTO dto);
	
	TurbineDTO findById(int id); 
	
	default List<TurbineDTO> findByCompanyName(String companyName){
		return Collections.emptyList();
	}
	
	Set<ConstraintViolation<TurbineDTO>> validateAndUpdate(TurbineDTO dto);
	
	default TurbineDTO deleteById(int id) {
		return null;
	}
}
