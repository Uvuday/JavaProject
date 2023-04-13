package com.turbineapp.repository;

import java.util.Collections;
import java.util.List;

import com.turbineapp.entity.TurbineEntity;

public interface TurbineRepository {

	boolean save(TurbineEntity entity);
	
	TurbineEntity findById(int id);
	
	default List<TurbineEntity> findByComapny(String companyName){
		return Collections.emptyList(); 
	}
	
	boolean update (TurbineEntity entity);
	
	default TurbineEntity deleteById(int id) {
		return null; 
	}
} 
