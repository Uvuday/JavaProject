package com.turbineapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "turbine")
@NamedQuery(name = "findByCompanyName" , query = "select anything from TurbineEntity anything where anything.companyName=:com")
public class TurbineEntity {

	@Id
	@Column(name = "t_id")
	private int id;
	
	@Column(name = "t_company_name")
	private String companyName;
	
	@Column(name = "t_cost")
	private Double cost;
	
	@Column(name = "t_type")
	private String type;
	
	@Column(name = "t_country")
	private String country;
}
