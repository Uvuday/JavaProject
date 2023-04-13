package com.turbineapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turbineapp.dto.TurbineDTO;
import com.turbineapp.entity.TurbineEntity;
import com.turbineapp.repository.TurbineRepository;

@Service
public class TurbineServiceImpl implements TurbineService {

	@Autowired
	public TurbineRepository turbineRepository;

	public TurbineServiceImpl() {
		System.out.println("Created "+this.getClass().getSimpleName());
	} 

	@Override
	public Set<ConstraintViolation<TurbineDTO>> saveAndValidate(TurbineDTO dto) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		Set<ConstraintViolation<TurbineDTO>> violations = validator.validate(dto);

		if(violations!=null && !violations.isEmpty()) {
 
			System.err.println("violations in dto "+dto);
			return violations;
		}else {
			System.out.println("violations is not there in dto can save");
			TurbineEntity entity = new TurbineEntity();
			BeanUtils.copyProperties(dto, entity); 

			boolean saved = this.turbineRepository.save(entity);
			System.out.println("Entity Data Is Saved "+saved);
			return Collections.emptySet();
		}  
	} 

	@Override
	public TurbineDTO findById(int id) {
		if(id>0) {
			TurbineEntity entity = this.turbineRepository.findById(id);
			if(entity!=null) {
				System.out.println("Entity is find in service for id..."+id);

				TurbineDTO dto = new TurbineDTO();
				BeanUtils.copyProperties(entity, dto);
				return dto;  
			}
		}
		return null;
	}

	@Override
	public List<TurbineDTO> findByCompanyName(String companyName) {

		System.out.println("Running findByCompanyName in service "+companyName);

		if(companyName!=null && !companyName.isEmpty()) {

			System.out.println("Company name is valid calling the repository");

			List<TurbineEntity> entities = this.turbineRepository.findByComapny(companyName);
			//List<E> ---> List<D>
			List<TurbineDTO> listOfDTO = new  ArrayList<TurbineDTO>();
			for (TurbineEntity entity : entities) {
				TurbineDTO dto = new TurbineDTO();
				BeanUtils.copyProperties(entity, dto);
				listOfDTO.add(dto);//adding to list
			}
			System.out.println("size of dto "+listOfDTO.size());
			System.out.println("Size of entity "+entities.size());
			return listOfDTO;
		}else {
			System.out.println("Company is invalid");
		}
		return TurbineService.super.findByCompanyName(companyName);
	}

	@Override
	public Set<ConstraintViolation<TurbineDTO>> validateAndUpdate(TurbineDTO dto) {

		System.out.println("Running validate and update in service "+dto);

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<TurbineDTO>> constraintViolations = validator.validate(dto);

		if (constraintViolations!=null && !constraintViolations.isEmpty()) {

			System.err.println("constraintViolations in dto, can not save");
			return constraintViolations;
		}else {

			System.out.println("No constraintViolations in dto can save "+dto);

			TurbineEntity entity = new TurbineEntity();
			BeanUtils.copyProperties(dto, entity);
 
			boolean saved = this.turbineRepository.update(entity);
			System.out.println("Entity data is saved "+saved);
			return Collections.emptySet();
		} 
	}
	
	@Override
	public TurbineDTO deleteById(int id) {

		System.out.println("Running Delete By Id in Service...");
		TurbineEntity entity = this.turbineRepository.deleteById(id);
		
		if (entity!=null) {
			TurbineDTO dto = new TurbineDTO();
			BeanUtils.copyProperties(entity, dto); 
			return dto;
		}else {
			System.err.println("Delete Is Invalid");
		}
		return TurbineService.super.deleteById(id);
	}
}  
